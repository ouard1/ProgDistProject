package com.example.authservice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTest {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://mysql:3306/clientsatisfaction";
        String username = "root";
        String password = "mploki78)P";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connection successful!");
            connection.close();
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}