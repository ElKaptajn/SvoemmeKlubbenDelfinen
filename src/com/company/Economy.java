package com.company;
import java.util.Scanner;
import java.io.IOException;

public class Economy {
    public static void economyMenu(Scanner input) {
        System.out.println("""
            
            *** Economy Menu ***
            Enter 1 to Show arrears
            Enter 2 to Show income
            Enter 3 to Edit members in arrears""");

        int answer = input.nextInt();
        switch(answer){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Number" + answer + "is not a valid option.");
                break;
        }
    }

    public static void arrears(){

    }

    public static void income(){

    }

    public static void membersInArrears(){

    }
}
