package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    public static void deleteData() {
        String user = "postgres";
        String password = "syed_sadique";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the begin ID : ");
        int Id = sc.nextInt();
        System.out.println("Enter the end Id: ");

        try(Connection cn = DatabaseUtil.connect();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM person WHERE id = ?");){




            ps.setInt(1,Id);


            System.out.println("Effected rows: "+ps.executeUpdate());

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getErrorCode());
        }
    }
}
