package uet.dictionary.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYSQLConnection {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "12345678";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dictionary";

    /**
     * Method Connection.
     *
     * @return connection
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
