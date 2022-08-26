package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private HelperRepository helperRepository;
    private PresentRepository presentRepository;
    private Shop shop;

    public ControllerImpl() {

        //тук седят само хелпъри и презънти, не са нито в лист, нито в мап
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
        this.shop = new ShopImpl();
    }

    @Override
    public String addHelper(String type, String helperName) {
        //Creates a helper with the given name of the given type and adds it to the corresponding repository.
        //If the helper is invalid, throw an IllegalArgumentException with a message:
        //"Helper type doesn't exist!"
        //The method should return the following message:
        //"Successfully added {helperType} named {helperName}!"

        Helper helper;

        switch (type) {
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;

            case "Happy":
                helper = new Happy(helperName);
                break;

            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }

        this.helperRepository.add(helper);
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        //Creates an instrument with the given power and adds it to the collection of the helper.
        //If the helper doesn't exist, throw an IllegalArgumentException with a message:
        //"The helper you want to add an instrument to doesn't exist!"
        //The method should return the following message:
        //"Successfully added instrument with power {instrumentPower} to helper {helperName}!"

        Helper helper = this.helperRepository.findByName(helperName);

        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        Instrument instrument = new InstrumentImpl(power);

        helper.addInstrument(instrument);

        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        //Creates a present with the provided name and required energy and adds it to the corresponding repository.
        //The method should return the following message:
        //•	"Successfully added Present: {presentName}!"

        Present present = new PresentImpl(presentName, energyRequired);
        this.presentRepository.add(present);

        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        //When the craft command is called, the action happens.
        //You should start crafting the given present, by assigning helpers which are almost ready:
        //•	The helpers that you should select are the ones with energy above 50 units.
        //•	The suitable ones start working on the given present.
        //•	If no helpers are ready, throw IllegalArgumentException with the following message:
        //"There is no helper ready to start crafting!"
        //•	After the work is done, you must return the following message, reporting whether the present is done and how many instruments have been broken in the process:
        //"Present {presentName} is {done/not done}. {countBrokenInstruments} instrument/s have been broken while working on it!"
        //Note: The name of the present you receive will always be a valid one.

        List<Helper> suitableHelpers = this.helperRepository.getModels()
                .stream()
                .filter(helper -> helper.getEnergy() > 50)
                .collect(Collectors.toList());

        if (suitableHelpers.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        int brokenInstruments = 0;
        Present present = this.presentRepository.findByName(presentName);

        for (Helper helper : suitableHelpers) {
            shop.craft(present, helper);

            brokenInstruments += (int) helper.getInstruments()
                    .stream()
                    .filter(Instrument::isBroken)
                    .count();
        }

        String printDoneOrNotDone;

        if (present.isDone()) {
            printDoneOrNotDone = "done";
        } else {
            printDoneOrNotDone = "not done";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PRESENT_DONE, presentName, printDoneOrNotDone));
        sb.append(String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments));

        return sb.toString().trim();
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        int countCraftedPresents = (int) this.presentRepository.getModels()
                .stream()
                .filter(Present::isDone)
                .count();

        sb.append(String.format("%d presents are done!%nHelpers info:%n", countCraftedPresents));

            for (Helper helper : this.helperRepository.getModels()) {
                sb.append(String.format("Name: %s%n", helper.getName()));
                sb.append(String.format("Energy: %d%n", helper.getEnergy()));

                List<Instrument> workingInstruments = helper.getInstruments()
                        .stream()
                        .filter(instrument -> !instrument.isBroken())
                        .collect(Collectors.toList());

                sb.append(String.format("Instruments: %d not broken left%n", workingInstruments.size()));
            }

        return sb.toString().trim();
    }
}
