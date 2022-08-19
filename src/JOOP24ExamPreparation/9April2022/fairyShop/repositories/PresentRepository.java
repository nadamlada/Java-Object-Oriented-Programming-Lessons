package fairyShop.repositories;

import fairyShop.models.Present;

import java.util.*;

public class PresentRepository implements Repository<Present>{
    //The present repository is a repository for presents that await to be crafted.
    //map -> name of present, Present

    private Map<String,Present> presents;

    public PresentRepository() {
        this.presents = new LinkedHashMap<>();
    }

    @Override
    public Collection<Present> getModels() {
        return Collections.unmodifiableCollection(this.presents.values());
    }

    @Override
    public void add(Present present) {
        this.presents.put(present.getName(), present);
    }

    @Override
    public boolean remove(Present present) {
        return this.presents.remove(present.getName()) != null;
    }

    @Override
    public Present findByName(String name) {
        return this.presents.get(name);
    }
}
