package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class Economy {

    public static void economyMenu(Scanner input, ArrayList<Member> members) throws IOException {
        System.out.println("""
                
                *** Economy Menu ***
                Enter 1 to Show arrears
                Enter 2 to Show income
                Enter 3 to Edit members in arrears""");

        int answer = input.nextInt();
        switch (answer) {
            case 1:
                arrears(members);
                break;
            case 2:
                income();
                break;
            case 3:
                //editMemberInArrears(input);
                break;
            default:
                System.out.println("Number" + answer + "is not a valid option.");
                break;
        }
    }

    public static void arrears(ArrayList<Member> members) {

        int arrearsSum = 0;
        int numberOfMembersInArrears = 0;

        System.out.println("\nInfo about members:\n");
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
                    subscription = (int) (1600 - (1600 * 0.25));
                } else subscription = 500;

                arrearsSum += subscription;
                individuelArrears = subscription;

                System.out.println("First name: "+members.get(i).fName +"\nLastname: "+members.get(i).lName +
                        "\nEmail: "+members.get(i).email + "\nArrears: " + individuelArrears + "\n");
            }
hej
        }
        System.out.println("Total number of members in arrears: " + numberOfMembersInArrears + "\n");
        System.out.println("Total amount in arrears: " + arrearsSum + "\n");
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

    /*
    public static void editMemberInArrears(Scanner input) {
        private ArrayList<Member> members = new ArrayList<>();

        String[] strArrayMember = new String[9];
        String[] sArr = new String[members.size()];
        Arrays.fill(sArr, "");

        System.out.println("Enter new arrears, '1' for true and '2' for false: ");
        int arrearsChoice = input.nextInt();
        boolean arrears;
        arrears = arrearsChoice != 1;
        strArrayMember[8] = String.valueOf(arrears);
    }
*/
}