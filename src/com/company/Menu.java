package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public void menuRank1(Scanner input, MemberHandler memberHandler) throws IOException { //Foreman
        int answer = 1;
        while (answer != 0) {
            System.out.println("""
                    ┌──────── Head menu ────────┐
                    │ Enter 0 for Logout        │
                    │ Enter 1 for Member Menu   │
                    └───────────────────────────┘""");
            answer = input.nextInt();
            if (answer == 1) {
                memberHandler.memberHandlerMenu(input);
            } else {
                if (answer != 0) {
                    System.out.println("Number " + answer + " is not a valid option");
                }
            }
        }
    }

    public void menuRank2(Scanner input, MemberHandler memberHandler) throws IOException { //The cashier
        int answer = 1;
        while (answer != 0) {
            System.out.println("""
                    ┌──────── Head menu ────────┐
                    │ Enter 0 for Logout        │
                    │ Enter 1 for Member Menu   │
                    │ Enter 2 for Economy Menu  │
                    └───────────────────────────┘""");
            answer = input.nextInt();
            switch (answer) {
                case 1:
                    memberHandler.memberHandlerMenu(input);
                    break;
                case 2:
                    Economy.economyMenu(input, memberHandler.getMembers());
                    break;
                default:
                    if (answer != 0) {
                        System.out.println("Number " + answer + " is not a valid option");
                    }
                    break;
            }
        }
    }

    public void menuRank3(Scanner input, MemberHandler memberHandler, Result result) throws IOException { //The coach
        int answer = 1;
        while (answer != 0) {
            System.out.println("""
                    ┌──────── Head menu ────────┐
                    │ Enter 0 for Logout        │
                    │ Enter 1 for Result Menu   │
                    └───────────────────────────┘""");
            answer = input.nextInt();
            if (answer == 1) {
                result.resultMenu(input, memberHandler.getMembers(), memberHandler.getCompetitionMembers());
            } else {
                if (answer != 0) {
                    System.out.println("Number " + answer + " is not a valid option");
                }
            }
        }
    }

    public void menuRankAdmin(Scanner input, EmployeesHandler employeesHandler, MemberHandler memberHandler, Result result) throws IOException { //Admin
        int answer = 1;
        while (answer != 0) {
            System.out.println("""
                    ┌──────── Head menu ────────┐
                    │ Enter 0 for Logout        │
                    │ Enter 1 for Member Menu   │
                    │ Enter 2 for Result Menu   │
                    │ Enter 2 for Economy Menu  │
                    │ Enter 4 for Employee Menu │
                    └───────────────────────────┘""");
            answer = input.nextInt();
            switch (answer) {
                case 1:
                    memberHandler.memberHandlerMenu(input);
                    break;
                case 2:
                    result.resultMenu(input, memberHandler.getMembers(), memberHandler.getCompetitionMembers());
                    break;
                case 3:
                    Economy.economyMenu(input, memberHandler.getMembers());
                    break;
                case 4:
                    employeesHandler.employeesMenu(input);
                    break;
                default:
                    if (answer != 0) {
                        System.out.println("Number " + answer + " is not a valid option TEST");
                    }
            }
        }
    }
}