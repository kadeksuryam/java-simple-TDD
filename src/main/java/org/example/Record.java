package org.example;
public class Record {
    private final int id;
    private final String name;

    public Record(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
