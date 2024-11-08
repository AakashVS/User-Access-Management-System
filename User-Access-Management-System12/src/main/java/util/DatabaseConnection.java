package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseConnection {

    private static final String propetieFile = "db.properties";

    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();

        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream(propetieFile)) {
            if (input == null) {
                throw new RuntimeException("Unable to find " + propetieFile);
            }
            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading database properties", e);
        }

        String url = props.getProperty("db.url");
        String username = props.getProperty("db.username");
        String password = props.getProperty("db.password");

        return DriverManager.getConnection(url, username, password);
    }
}
