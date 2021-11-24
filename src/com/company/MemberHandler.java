package com.company;

import java.util.ArrayList;
import java.util.Scanner;

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
    public void createMember(){

    }
}
