package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExplorerRepository implements Repository<Explorer> {
    private Map<String, Explorer> explorers;

    public ExplorerRepository() {
        this.explorers = new LinkedHashMap<>();
    }

    @Override
    public void add(Explorer explorer) {
        this.explorers.put(explorer.getName(), explorer);
    }

    @Override
    public boolean remove(Explorer explorer) {
        return this.explorers.remove(explorer.getName()) != null;
    }

    @Override
    public Collection<Explorer> getCollection() {
        //Returns an unmodifiable collection of explorers.
        return Collections.unmodifiableCollection(this.explorers.values());
    }

    @Override
    public Explorer byName(String name) {
        return explorers.get(name);
    }
}
