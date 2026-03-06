package org.example;

import java.sql.*;

public class Display {
    public static void viewAll() {
        String user = "postgres";
        String password = "syed_sadique";
        String url = "jdbc:postgresql://localhost:5432/test";

        String query = "SELECT * FROM person ORDER BY id DESC";

        try(Connection cn = DatabaseUtil.connect();
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();){



            while(rs.next()){
                System.out.println("id: "+ rs.getInt(1));
                System.out.println("first_name: "+rs.getString(2));
                System.out.println("last_name: "+rs.getString(3));
                System.out.println("email: "+rs.getString(4));
                System.out.println("gender: "+rs.getString(5));
                System.out.println("Date: "+rs.getDate(6));
                System.out.println("country_of_birth: "+rs.getString(7));

                System.out.println("----------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error: "+ e.getMessage());
            throw new RuntimeException(e);

        }


    }
}
