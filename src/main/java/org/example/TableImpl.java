package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableImpl implements Table{
    private final Connection conn;

    public TableImpl() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite::memory:");
            try (PreparedStatement stmt = conn.prepareStatement("CREATE TABLE records (id INTEGER PRIMARY KEY, name TEXT)")) {
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize SQLiteTable", e);
        }
    }

    @Override
    public boolean insertRecord(Record record) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO records (id, name) VALUES (?, ?)")) {
            stmt.setInt(1, record.getId());
            stmt.setString(2, record.getName());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
