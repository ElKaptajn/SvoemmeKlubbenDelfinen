package com.company;

import java.util.*;

public class MemberHandler {
    private ArrayList<Member> members = new ArrayList<>();

    public void memberHandlerMenu(Scanner input) {
        System.out.println("""
                *** Member menu ***
                Enter 0 to exit program
                Enter 1 to Create new member
                Enter 2 to Edit member""");
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                break;
            case 2:
                break;
            default:
                System.out.println("Number " + answer + " is not a valid option");
                break;

        }
    }

    public void createMember() {

    }
    public ArrayList<Member> addMember(Scanner input) {
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
        int ageType = 0;
        String teamType = "None";
        if (age < 18) {
            ageType = 1;
            teamType = "Junior";
        } else if (age > 18 && age < 60) {
            ageType = 2;
            teamType = "Senior";
        }
        String activityType = "Motionist";
        boolean status = true;
        boolean restance = false;

        Member member = new Member(ageType, activityType, teamType, status, fName, lName, age, email, address, restance);
        members.add(member);
        return members;
    }
}
