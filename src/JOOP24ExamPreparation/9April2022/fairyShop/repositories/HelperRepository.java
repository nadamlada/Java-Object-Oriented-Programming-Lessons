package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class HelperRepository implements Repository<Helper> {
    //The helper repository is a repository for the helpers working at Fairy’s Shop.
    //map -> name of helper, Helper
    private Map<String, Helper> helperRepository;

    public HelperRepository() {
        this.helperRepository = new LinkedHashMap<>();
    }

    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(this.helperRepository.values());
    }

    @Override
    public void add(Helper helper) {
        this.helperRepository.put(helper.getName(), helper);
    }

    @Override
    public boolean remove(Helper helper) {
        return this.helperRepository.remove(helper.getName()) != null;
    }

    @Override
    public Helper findByName(String name) {
        return this.helperRepository.get(name);
    }
}
