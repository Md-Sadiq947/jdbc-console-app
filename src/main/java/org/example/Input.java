package org.example;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Input {
    public static void insertData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first_name: ");
        String first_name = sc.nextLine();
        System.out.println("Enter last_name: ");
        String last_name = sc.nextLine();
        System.out.println("Enter gender: ");
        String gender = sc.nextLine();
        System.out.println("Enter date-of-birth in YYYY-MM-DD format: ");
        String date_of_birth = sc.nextLine();
        System.out.println("Enter country_of_birth: ");
        String country_of_birth = sc.nextLine();



        String query = "INSERT INTO person(first_name, last_name, gender, date_of_birth, country_of_birth)" +  "VALUES(?,?,?,?,?)";


        try(Connection cn = DatabaseUtil.connect();
            PreparedStatement psmt = cn.prepareStatement(query);){

            psmt.setString(1,first_name);
            psmt.setString(2, last_name);
            psmt.setString(3,gender);
            psmt.setDate(4, Date.valueOf(LocalDate.parse(date_of_birth)));
            psmt.setString(5,country_of_birth);


            System.out.println(psmt.executeUpdate());



        }catch (SQLException e){
            System.out.println("Error " + e.getMessage() + " " + e.getErrorCode());
        }



    }
}
