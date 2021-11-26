package com.company;

import java.util.*;

public class MemberHandler {
    private ArrayList<Member> members = new ArrayList<>();

    public void memberHandlerMenu(Scanner input) {
        System.out.println("""
                *** Member menu ***
                Enter 0 to exit program
                Enter 1 to Create new member
                Enter 2 to Edit member
                Enter 3 to Delete member""");
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                createMember(input);
                break;
            case 2:
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
        String address = input.next();
        String teamType = "None";
        String activityType = "";
        System.out.println("Enter activity form, \"1\" for Motionist, \"2\" for Competition Swimmer");
        int activityTypeChoice = input.nextInt();
        while (activityTypeChoice > 2) {
            System.out.println("Invalid number: " + activityTypeChoice);
            activityTypeChoice = input.nextInt();
        }
        if (activityTypeChoice == 1){
            activityType = "Motionist";
        } else if (activityTypeChoice == 2){
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
}
