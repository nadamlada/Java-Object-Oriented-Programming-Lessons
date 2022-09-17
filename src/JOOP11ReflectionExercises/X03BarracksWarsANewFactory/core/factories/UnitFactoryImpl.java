package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
        // TODO: implement for problem 3
//
//        switch (unitType) {
//            case "Archer":
//                return new Archer();
//
//            case "Swordsman":
//                return new Swordsman();
//
//            case "Pikeman":
//                return new Pikeman();
//
//            case "Horseman":
//                return new Horseman();
//
//            case "Gunner":
//                return new Gunner();
//        }

        try {
            //взимаме класа, взимаме конструктора, и викаме конструктора
            Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<Unit> unitConstructor = unitClass.getDeclaredConstructor();
            return unitConstructor.newInstance();

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            return null;
        }
    }
}
