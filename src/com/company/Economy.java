package com.company;

import java.io.File;
import java.io.FileNotFoundException;
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

    public static void income() throws FileNotFoundException {

        Scanner reader = new Scanner(new File("Files/MemberList"));

        int income = 0;

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

            int subscription = 0;
            if (statusT && ageT < 18) {
                subscription = 1000;
            } else if (statusT && ageT >= 18 && ageT < 60) {
                subscription = 1600;
            } else if (statusT && ageT >= 60) {
                subscription = (int) (1600 - (1600 * 0.25));
            } else subscription = 500;

            income += subscription;

        }
        System.out.println("\nExpected income: " + income + " DKK\n");
    }

    public static void membersInArrears() {
        Scanner reader = new Scanner(new File("Files/MemberList"));

        int count = 0;
        while (reader.hasNextLine()) {
            String[] memberInfo = reader.nextLine().split(", ");
            if (memberInfo[0].equals("No")) {
                memberInfo[0] = "false";
            } else {
                memberInfo[0] = "true";
            }
            boolean statusT = Boolean.parseBoolean(memberInfo[9]);

            int arrayCount = 0;
            if (memberInfo[9] == "True") {
                arrayCount++;
            }else{

            }

            count += arrayCount;


        }
}
