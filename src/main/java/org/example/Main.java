package org.example;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1, Add Person");
            System.out.println("2, View All");
            System.out.println("3, Update");
            System.out.println("4, Delete");
            System.out.println("5, Exit");

            System.out.println("********************");

            System.out.println("Enter your choice: ");
            int choice;
            try{
                choice = sc.nextInt();
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Error: " + e.getMessage());
                continue;
            }
            switch (choice){
                case 1:
                    Input.insertData();
                    break;
                case 2:
                    Display.viewAll();
                    break;
                case 3:
                    Update.updateTable();
                    break;
                case 4:
                    Delete.deleteData();
                    break;
                case 5:
                    System.out.println("Exit from the Database");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }

    }

}