package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableTest {
    private final Record record = new Record(1, "John Doe");
    private Table table;

    @BeforeEach
    public void init() {
        table = new TableImpl();
    }

    @Test
    public void testInsertRecord() {
        boolean result = table.insertRecord(record);
        assertTrue(result, "Insertion of record failed");
    }
}
