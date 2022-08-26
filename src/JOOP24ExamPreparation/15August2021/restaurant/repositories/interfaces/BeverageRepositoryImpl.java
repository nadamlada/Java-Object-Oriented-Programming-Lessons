package restaurant.repositories.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;

import java.util.ArrayList;
import java.util.Collection;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private Collection<Beverages> beverageRepositoryImpl;

    public BeverageRepositoryImpl() {
        this.beverageRepositoryImpl = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
      return this.beverageRepositoryImpl.stream()
              .filter(b -> b.getName().equals(drinkName))
              .filter(b -> b.getBrand().equals(drinkBrand))
              .findFirst()
              .orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return this.beverageRepositoryImpl;
    }

    @Override
    public void add(Beverages entity) {
        this.beverageRepositoryImpl.add(entity);
    }
}
