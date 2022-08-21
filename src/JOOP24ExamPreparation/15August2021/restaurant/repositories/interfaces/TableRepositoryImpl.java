package restaurant.repositories.interfaces;

import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public class TableRepositoryImpl implements TableRepository<Table>{
    private Collection<Table> tableRepositoryImpl;

    public TableRepositoryImpl() {
        this.tableRepositoryImpl = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
       return this.tableRepositoryImpl;
    }

    @Override
    public void add(Table entity) {
        this.tableRepositoryImpl.add(entity);
    }

    @Override
    public Table byNumber(int number) {
        return this.tableRepositoryImpl.stream()
                .filter(t -> t.getTableNumber() == number)
                .findFirst()
                .orElse(null);
    }
}
