package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqLite {
    public static Connection connection(String path, String baseName) {
        return createOrOpen(path, baseName);
    }

    public final Connection conn;

    public SqLite(String path, String baseName) {
        this.conn = createOrOpen(path, baseName);
    }

    private static Connection createOrOpen(String caminho, String baseName) {
        if (!baseName.endsWith(".db")) baseName = baseName + ".db";
        String url = "jdbc:sqlite:" + caminho + baseName;
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}