package org.example;

import java.util.HashMap;

public class TableImpl implements Table{
    private final HashMap<Integer, Record> table;

    public TableImpl() {
        table = new HashMap<>();
    }

    @Override
    public boolean insertRecord(Record record) {
        if (table.containsKey(record.getId())) {
            return false;
        }
        table.put(record.getId(), record);
        return true;
    }
}
