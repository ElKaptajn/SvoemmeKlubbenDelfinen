package com.company;

import java.io.File;
import java.util.ArrayList;
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
                //income();
                incomeTest();
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

    public static void income() throws IOException { //find lige ud af hvorfor det skal være IO og ikke være FileNotFound
        Scanner reader = new Scanner(new File("Files/MemberList"));

        while (reader.hasNextLine()) {
            boolean statusT = Boolean.parseBoolean(reader.next());
            reader.next();
            reader.next();
            String teamTypeT = reader.next();
            reader.next();
            reader.next();
            int ageT = reader.nextInt();
            reader.next();
            reader.next();
            reader.nextBoolean();

            System.out.println(ageT);
        }


    }

    public static void incomeTest() throws IOException { //find lige ud af hvorfor det skal være IO og ikke være FileNotFound
        Scanner reader = new Scanner(new File("Files/MemberList"));

        while (reader.hasNextLine()) {
            String[] memberInfo = reader.nextLine().split(", ");
            if (memberInfo[0].equals("Active")) {
                memberInfo[0] = "true";
            } else {
                memberInfo[0] = "false";
            }
            boolean statusT = Boolean.parseBoolean(memberInfo[0]);
            String teamTypeT = memberInfo[2];
            int ageT = Integer.parseInt(memberInfo[5]);


            System.out.println(statusT);
            System.out.println(teamTypeT);
            System.out.println(ageT);

            int kontigent = 0;
            if (statusT && ageT < 18) {
                kontigent = 1000;
            } else if (statusT && (ageT >= 18 && ageT < 60)) {
                kontigent = 1600;
            } else if (statusT && ageT >= 60) {
                kontigent = (int) (1600 - (1600 * 0.25));
            } else kontigent = 500;

            System.out.println(kontigent);
        }
    }


    public static void membersInArrears() {

    }
}
