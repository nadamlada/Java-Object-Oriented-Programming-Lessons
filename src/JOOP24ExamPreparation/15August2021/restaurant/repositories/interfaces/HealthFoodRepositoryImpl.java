package restaurant.repositories.interfaces;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {
    private Collection<HealthyFood> healthFoodRepositoryImpl;

    public HealthFoodRepositoryImpl() {
        this.healthFoodRepositoryImpl = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        return this.healthFoodRepositoryImpl.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return this.healthFoodRepositoryImpl;
    }

    @Override
    public void add(HealthyFood entity) {
        this.healthFoodRepositoryImpl.add(entity);
    }
}
