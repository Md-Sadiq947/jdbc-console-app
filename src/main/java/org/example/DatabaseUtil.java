package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    public static Connection connect() {

        String url = "jdbc:postgresql://localhost:5432/test";
        String user = "postgres";
        String password = "syed_sadique";

        Connection obj = null;

        try{
             obj = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return obj;
    }
}
