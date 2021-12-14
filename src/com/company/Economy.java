package com.company;

import java.io.*;
import java.util.*;

/**
 * @author Josefine
 * @author Tonje
 */

public class Economy {

    public static void economyMenu(Scanner input, ArrayList<Member> members) throws IOException {
        int answer = 1;
        while (answer != 0) {
            System.out.println("""
                    ┌─────────── Economy Menu ───────────┐
                    │ Enter 0 to exit Economy menu       │
                    │ Enter 1 to Show arrears            │
                    │ Enter 2 to Show income             │
                    └────────────────────────────────────┘""");

            answer = input.nextInt();
            switch (answer) {
                case 1:
                    arrears(members);
                    break;
                case 2:
                    income();
                    break;
                default:
                    if (answer == 0) {
                        break;
                    } else {
                        System.out.println("┌────────────────────────────────────────────┐");
                        System.out.println("│ Number " + answer + " is not a valid option");
                        System.out.println("└────────────────────────────────────────────┘");
                    }
            }
        }
    }


    public static void arrears(ArrayList<Member> members) {

        int arrearsSum = 0;
        int numberOfMembersInArrears = 0;

        System.out.println("\n┌───────── Info about members ──────────┐");
        for (int i = 0; i < members.size(); i++) {
            int individuelArrears = 0;

            if (members.get(i).arrears == true) { //restance true betyder member er i restance.
                numberOfMembersInArrears++;

                int subscription = 0;
                if (members.get(i).status && members.get(i).age < 18) {
                    subscription = 1000;
                } else if (members.get(i).status && members.get(i).age >= 18 && members.get(i).age < 60) {
                    subscription = 1600;
                } else if (members.get(i).status && members.get(i).age >= 60) {
                    subscription = (int) (1600 - (1600 * 0.25)); //1600 * 0,75
                } else subscription = 500;

                arrearsSum += subscription;
                individuelArrears = subscription;

                System.out.printf("│ Firstname: %25s  │\n│ Lastname: %26s  │\n│ Email: %29s  │\n│ Arrears: %23d DKK  │\n", members.get(i).fName, members.get(i).lName, members.get(i).email, individuelArrears);
                System.out.println("├───────────────────────────────────────┤");
            }
        }
        System.out.println("├─────────────── Arrears ───────────────┤\n│\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│ Total number of members in arrears: " + numberOfMembersInArrears + " │\n│\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│ Total amount in arrears: " + arrearsSum + " DKK     │\n│\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("└───────────────────────────────────────┘\n");
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
        System.out.printf("""
                ╭—————————— Income (Year) ———————————╮
                │ Expected income  │ %11d DKK │
                ╰————————————————————————————————————╯
                                
                """, income);
    }
}