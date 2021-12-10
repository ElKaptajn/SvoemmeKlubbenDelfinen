package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        MemberHandler memberHandler = new MemberHandler();
        Result result = new Result();
        updateMemberArrayList(memberHandler.getMembers());
        result.updateCompetitionMemberList(memberHandler.getCompetitionMembers());
        EmployeesHandler employeesHandler = new EmployeesHandler();
        updateEmployeesArrayList(employeesHandler.getEmployees());
        int answer = 1;
        while (answer != 2) {
            /*System.out.println("""
                    ┌────────── Login ──────────┐
                    │ Enter 0. for exit program │
                    │ Enter 1. for Login        │
                    └───────────────────────────┘""");*/
            System.out.println("┌────────── Login ──────────┐" +
                    "\n│ 1. Login                  │" +
                    "\n│ 2. Exit program           │" +
                    "\n└─ " + "Choose an option: [1-2]" + " ─┘");
            answer = input.nextInt();
            input.nextLine();
            switch (answer) {
                case 1:
                    loginTestingArray(input, employeesHandler, memberHandler, result);
                    break;
                default:
                    if (answer == 2) {
                        System.out.println("""                   
                                \n┌───────────────────────────────┐
                                │ Thanks for using the program! │
                                └───────────────────────────────┘
                                """);
                    } else {
                        System.out.printf("""
                                ┌─────────────────────────────────────┐
                                │ Number: %-2d | Is not a valid option! │
                                └─────────────────────────────────────┘
                                \n""", answer);
                    }
                    break;
            }
        }
        /*
        while (answer != 0) {
            System.out.println("""
                    ┌──────── Head menu ────────┐
                    │ Enter 0 for exit program  │
                    │ Enter 1 for Member Menu   │
                    │ Enter 2 for Result Menu   │
                    │ Enter 3 for Economy Menu  │
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
                default:
                    if (answer == 0) {
                        System.out.println("Thanks for using the program!");
                    } else {
                        System.out.println("Number " + answer + " is not a valid option");
                    }
                    break;

            }
        }*/
    }

    public static void loginTestingArray(Scanner sc, EmployeesHandler employeesHandler, MemberHandler memberHandler, Result result) throws IOException {
        Menu menu = new Menu();
        int size = 0;
        BufferedReader reader = new BufferedReader(new FileReader("Files/Employees/employees"));
        while (reader.readLine() != null) size++;
        Scanner readMember = new Scanner(new File("Files/Employees/employees"));
        String[] ranking = new String[size];
        String[] username = new String[size];
        String[] password = new String[size];
        int tempI = 0;
        while (readMember.hasNextLine()) {
            String[] memberInfo = readMember.nextLine().split(" ");
            ranking[tempI] = memberInfo[0];
            username[tempI] = memberInfo[1];
            password[tempI] = memberInfo[2];
            tempI++;
        }
        readMember.close();
        boolean loginTF = false;
        while (!loginTF) {
            System.out.println("┌───────── Login ─────────┐");
            System.out.print("│ Username: ");
            String inpUser = sc.nextLine();
            System.out.print("│ Password: ");
            String inpPass = sc.nextLine(); // gets input from user
            System.out.println("├─────────────────────────┐");
            for (int i = 0; i < size; i++) {
                if (inpUser.equals(username[i]) && inpPass.equals(password[i])) {
                    System.out.println("│  Login was successful!  │");
                    System.out.println("└─────────────────────────┘\n");
                    switch (ranking[i]) {
                        case "Foreman" -> menu.menuRank1(sc, memberHandler);
                        case "Cashier" -> menu.menuRank2(sc, memberHandler);
                        case "Coach" -> menu.menuRank3(sc, memberHandler, result);
                        case "Admin" -> menu.menuRankAdmin(sc, employeesHandler, memberHandler, result);
                    }
                    loginTF = true;
                }
            }
            if (!loginTF) {
                if (!inpUser.equals(username[size - 1]) && !inpPass.equals(password[size - 1]) ||
                        inpUser.equals(username[size - 1]) && !inpPass.equals(password[size - 1]) ||
                        !inpUser.equals(username[size - 1]) && inpPass.equals(password[size - 1])) {
                    System.out.print("│Wrong username/password! │ \n│Try again? (y/n): ");
                }
                String yesOrNo = sc.next();
                if (!yesOrNo.equalsIgnoreCase("Y") && !yesOrNo.equalsIgnoreCase("YES")) {
                    loginTF = true;
                }
                System.out.println("└─────────────────────────┘\n");
            }
            sc.nextLine();
        }
    }


    /**
     * Updating arraylist from the file
     */
    public static void updateMemberArrayList(ArrayList<Member> members) throws FileNotFoundException {
        Scanner readMember = new Scanner(new File("Files/MemberList"));
        while (readMember.hasNextLine()) {
            String[] memberInfo = readMember.nextLine().split(", ");
            if (memberInfo[0].equals("Active")){
                memberInfo[0] = "true";
            } else {
                memberInfo[0] = "false";
            }
            if (memberInfo[6].equals("Male")) {
                memberInfo[6] = "true";
            } else if (memberInfo[6].equals("Female")) {
                memberInfo[6] = "false";
            }
            if (memberInfo[9].equals("Yes")){
                memberInfo[9] = "true";
            } else {
                memberInfo[9] = "false";
            }
            Member member = new Member(Boolean.parseBoolean(memberInfo[0]), memberInfo[1], memberInfo[2], memberInfo[3], memberInfo[4], Integer.parseInt(memberInfo[5]), Boolean.parseBoolean(memberInfo[6]), memberInfo[7], memberInfo[8], Boolean.parseBoolean(memberInfo[9]));
            members.add(member);
        }
        readMember.close();
    }

    public static void updateEmployeesArrayList(ArrayList<Employees> employees) throws FileNotFoundException {
        Scanner readEmployee = new Scanner(new File("Files/Employees/employees"));
        while (readEmployee.hasNextLine()) {
            String[] employeeInfo = readEmployee.nextLine().split(" ");
            Employees employee = new Employees(employeeInfo[0], employeeInfo[1], employeeInfo[2]);
            employees.add(employee);
        }
        readEmployee.close();
    }
}
