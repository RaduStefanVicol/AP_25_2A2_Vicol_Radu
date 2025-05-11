package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/cities";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
             connection = DriverManager.getConnection(
                    URL, "myUserName", "mySecretPassword");
        } catch(SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        } finally {
            if (connection != null) connection.close() ;
        }
        return connection;
    }

    private static void createConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL);

            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

    public static void rollback() {
    }
}