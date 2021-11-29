package com.company;

import java.io.IOException;
import java.util.*;

public class MemberHandler {
    private ArrayList<Member> members = new ArrayList<>();

    public void memberHandlerMenu(Scanner input) throws IOException {
        System.out.println("""
                *** Member menu ***
                Enter 0 to exit program
                Enter 1 to Create new member
                Enter 2 to Delete member
                Enter 3 to Edit member""");
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                createMember(input);
                break;
            case 2:
                deleteMember(input);
                break;
            case 3:
                editMember(input);
                break;
            default:
                System.out.println("Number " + answer + " is not a valid option");
                break;
        }
    }

    public ArrayList<Member> createMember(Scanner input) {
        System.out.println("Enter firstname: ");
        String fName = input.next();
        System.out.println("Enter lastname: ");
        String lName = input.next();
        System.out.println("Enter age: ");
        int age = input.nextInt();
        System.out.println("Enter email: ");
        String email = input.next();
        System.out.println("Enter address: ");
        String address = input.nextLine();
        String teamType = "None";
        String activityType = "";
        System.out.println("Enter activity form, \"1\" for Motionist, \"2\" for Competition Swimmer");
        int activityTypeChoice = input.nextInt();
        while (activityTypeChoice > 2) {
            System.out.println("Invalid number: " + activityTypeChoice);
            activityTypeChoice = input.nextInt();
        }
        if (activityTypeChoice == 1) {
            activityType = "Motionist";
        } else if (activityTypeChoice == 2) {
            activityType = "Competition Swimmer";
        }
        if ((age < 18) && (activityType.equals("Competition Swimmer"))) {
            teamType = "Junior";
        } else if (age > 18 && age < 60 && (activityType.equals("Competition Swimmer"))) {
            teamType = "Senior";
        }

        boolean status = true;
        boolean restance = false;

        Member member = new Member(activityType, teamType, status, fName, lName, age, email, address, restance);
        members.add(member);

        System.out.println(members);

        return members;
    }

    public ArrayList<Member> deleteMember(Scanner input) throws IOException {
        if (members.size() > 1) {
            for (int i = 0; i < members.size(); i++) {
                System.out.printf("Nr. %-2d: %s %b \n", (i + 1), members.get(i).fName, members.get(i).restance);
            }
            System.out.println("Enter corresponding number for removing: ");
            int removeChoice = input.nextInt();
            members.remove(removeChoice - 1);
            //FileProcessor.writeToCarFile(cars);
        } else {
            System.out.println("There is no members!\n");
        }
        return members;
    }

    public void editMember(Scanner input) throws IOException {
        System.out.println("Enter number for which member you want to change info about: ");
        int picked = input.nextInt();

        String[] strArrayMember = new String[9];

        String[] sArr = new String[members.size()];
        Arrays.fill(sArr, "");

        String s = String.valueOf(members.get(picked - 1));
        String[] strArr = s.split("\n");
        for (int j = 0; j < 9; j++) {
            sArr[picked - 1] += strArr[j] + "\n";
            strArrayMember = sArr[picked - 1].split("\n");
        }
        for (int i = 0; i < strArrayMember.length; i++) {
            System.out.println("Nr. " + (i + 1) + ": " + strArrayMember[i]);
            String newLastMember = strArrayMember[i].substring(strArrayMember[i].indexOf(": ") + 2);
            strArrayMember[i] = newLastMember;
        }
        System.out.println("Enter number for which info you want to change: ");
        int pickInfoF = input.nextInt();
        input.nextLine();
        switch (pickInfoF) {
            case 1:
                System.out.println("Enter new activity form, \"1\" for Motionist, \"2\" for Competition Swimmer");
                int activityTypeChoice = input.nextInt();
                while (activityTypeChoice > 2) {
                    System.out.println("Invalid number: " + activityTypeChoice);
                    activityTypeChoice = input.nextInt();
                }
                if (activityTypeChoice == 1) {
                    strArrayMember[0] = "Motionist";
                } else if (activityTypeChoice == 2) {
                    strArrayMember[0] = "Competition Swimmer";
                }
                break;
            case 2: //Todo updater automatisk udfra age?
                System.out.println("Enter new team type: ");
                strArrayMember[1] = input.next();
                break;
            case 3:
                System.out.println("Enter new status, '1' for active and '2' for passive: ");
                int statusChoice = input.nextInt();
                boolean status;
                status = statusChoice != 1;
                strArrayMember[2] = String.valueOf(status);
                break;
            case 4:
                System.out.println("Enter new first name: ");
                strArrayMember[3] = input.next();
                break;
            case 5:
                System.out.println("Enter new last name: ");
                strArrayMember[4] = input.next();
                break;
            case 6:
                System.out.println("Enter new age: ");
                strArrayMember[5] = String.valueOf(input.nextInt());
                break;
            case 7:
                System.out.println("Enter new email: ");
                strArrayMember[6] = input.next();
                break;
            case 8:
                System.out.println("Enter new address: ");
                strArrayMember[7] = input.nextLine();
                break;
            case 9:
                System.out.println("Enter new restance, '1' for true and '2' for false: ");
                int restanceChoice = input.nextInt();
                boolean restance;
                restance = restanceChoice != 1;
                strArrayMember[8] = String.valueOf(restance);
                break;
        }
        Member member = new Member(strArrayMember[0], strArrayMember[1], Boolean.parseBoolean(strArrayMember[2]), strArrayMember[3], strArrayMember[4], Integer.parseInt(strArrayMember[5]), strArrayMember[6], strArrayMember[7], Boolean.parseBoolean(strArrayMember[8]));
        members.set(picked - 1, member);
    }
}
