package org.example;

import java.sql.*;
import java.util.Scanner;

public class Update {
    public static void updateTable() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the email to be changed: ");
        String updatedEmail = sc.nextLine();
        System.out.println("At id no: ");
        int id = sc.nextInt();

        //Create the connection:
        String user = "postgres";
        String password = "syed_sadique";

        String url = "jdbc:postgresql://localhost:5432/test";

        try(Connection cn = DatabaseUtil.connect();
            PreparedStatement ps = cn.prepareStatement("UPDATE person SET email = ? WHERE id = ?");){




            ps.setString(1,updatedEmail);
            ps.setInt(2,id);

            System.out.println("Updated rows: " + ps.executeUpdate());


        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getErrorCode());
        }
    }
}
