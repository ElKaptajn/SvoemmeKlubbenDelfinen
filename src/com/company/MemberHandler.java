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
            System.out.println("There is no members!");
        }
        return members;
    }

}
