package com.company;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Economy {

    public static void economyMenu(Scanner input) throws IOException {
        System.out.println("""
                            
                *** Economy Menu ***
                Enter 1 to Show arrears
                Enter 2 to Show income
                Enter 3 to Edit members in arrears""");

        int answer = input.nextInt();
        switch (answer) {
            case 1:
                break;
            case 2:
                income();
                break;
            case 3:
                break;
            default:
                System.out.println("Number" + answer + "is not a valid option.");
                break;
        }
    }

    public static void arrears() {

    }

    public static void income() throws IOException {
        Scanner reader = new Scanner(new File("Files/MemberList"));

        while (reader.hasNextLine()) { //tilføj * efter alle members for at adskille members
            String activityTypeT = reader.next();
            reader.next();
            String statusT = reader.next();
            reader.next();
            reader.next();
            String ageT = reader.next();
            System.out.println(ageT);
        }
        int kontigent = 0;
        if (status == active && age < 18) {
            kontigent = 1000;
        } else if (status == active && (age >= 18 && age < 60)) {
            kontigent = 1600;
        } else if (status == active && age >= 60) {
            kontigent = 1600 - (1600 * 0.25);
        } else (status == passive)
        kontigent = 500;
    }


    public static void membersInArrears() {

    }
}
