package system_patterns.orm;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum Connect implements Closeable {
    INSTANCE;

    private final Connection connection;

    Connect() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("./../../application.properties"));
            String login = properties.getProperty("username");
            String password = properties.getProperty("password");
            String host = properties.getProperty("host");
            String port = properties.getProperty("port");
            String db = properties.getProperty("database");
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db, login, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
