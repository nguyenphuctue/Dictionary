package uet.dictionary.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MYSQLConnection {
    private static final String FILE_CONFIG = "\\db.properties";

    /**
     * Method Connection.
     * @return connection
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        Properties properties = new Properties();
        InputStream inputStream = null;

        try {
            String currentDir = System.getProperty("user.dir");
            inputStream = new FileInputStream(currentDir + FILE_CONFIG);

            properties.load(inputStream);

            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
