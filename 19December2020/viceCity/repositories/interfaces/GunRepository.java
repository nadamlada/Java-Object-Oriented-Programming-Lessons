package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GunRepository implements Repository<Gun> {
    private Map<String,Gun> guns;

    public GunRepository() {
        this.guns = new HashMap<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return guns.values();
    }

    @Override
    public void add(Gun model) {
        guns.putIfAbsent(model.getName(), model);
    }

    @Override
    public boolean remove(Gun model) {
        //връща или оръжието, което сме премахнали, или нъл, ако е нямало такова в мапа
        return this.guns.remove(model.getName()) !=null;
    }

    @Override
    public Gun find(String name) {
       return this.guns.get(name);
    }
}
