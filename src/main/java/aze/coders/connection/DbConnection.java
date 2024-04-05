package aze.coders.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String url="jdbc:postgresql://localhost:5432/DB";
    private static final String password = "ShamilSql03";
    private static final String username = "postgres";
    private static Connection connection;
    public static Connection getConnection(){
        try {
            connection= DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the Database");
            return connection;
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting the Database");
            throw new RuntimeException(e);
        }

    }
    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while closing the connection");
            throw new RuntimeException(e);
        }
    }

}
