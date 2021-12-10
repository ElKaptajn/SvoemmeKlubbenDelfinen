package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EmployeesHandler {
    private ArrayList<Employees> employees = new ArrayList<>();

    public void employeesMenu(Scanner input) throws IOException {
        int answer = 1;
        while (answer != 0) {
            System.out.println("""
                    ----------- Employee menu ---------
                    | Enter 0 for Logout              |
                    | Enter 1 for Create Employee     |
                    | Enter 2 for Delete Employee     |
                    | Enter 3 for Edit Employee       |
                    | Enter 4 for Show Employee       |
                    -----------------------------------""");
            answer = input.nextInt();
            switch (answer) {
                case 1:
                    createEmployee(input);
                    break;
                case 2:
                    deleteEmployee(input);
                    break;
                case 3:
                    editEmployee(input);
                    break;
                case 4:
                    showEmployee(input);
                    break;
                default:
                    if (answer == 0) {
                        break;
                    } else {
                        System.out.println("Number " + answer + " is not a valid option");
                    }
            }
            writeToEmployeeFile(employees);
        }
    }

    public ArrayList<Employees> createEmployee(Scanner input) { //FIXME make ranking
        System.out.println("-------------- Create Employee --------------");
        String rank = "";
        int rankChoice = 0;
        while (rankChoice > 4 || rankChoice < 1) {
            System.out.println("""
                    | Rank?
                    | 1. for Foreman
                    | 2. for Cashier
                    | 3. for Coach
                    | 4. for Admin""");
            System.out.print("| Enter rank: ");
            rankChoice = input.nextInt();
            switch (rankChoice) {
                case 1 -> rank = "Foreman";
                case 2 -> rank = "Cashier";
                case 3 -> rank = "Coach";
                case 4 -> rank = "Admin";
                default -> System.out.printf("""
                        ---------------------------------------------
                        | Choice %d not valid
                        ---------------------------------------------
                        """, rankChoice);
            }
        }
        System.out.print("| Enter username: ");
        String username = input.next();
        System.out.print("| Enter password: ");
        String password = input.next();
        System.out.println("");
        System.out.println("""
                ---------------------------------------------
                |      Created employee was successful!     |
                ---------------------------------------------
                """);
        Employees employee = new Employees(rank, username, password);
        employees.add(employee);

        return employees;
    }

    public ArrayList<Employees> deleteEmployee(Scanner input) {
        if (employees.size() >= 1) {
            System.out.println("--------- Delete Employee ---------");
            for (int i = 0; i < employees.size(); i++) {
                System.out.printf("| Nr. %-2d | %-9s | %-10s |\n", (i + 1), employees.get(i).rank, employees.get(i).username);
            }
            System.out.println("""
            -----------------------------------
            |         Enter 0 to exit         |
            -----------------------------------
            """);
            System.out.println("Enter corresponding number for removing: ");
            int removeChoice = input.nextInt();
            if (removeChoice != 0) {
                employees.remove(removeChoice - 1);
            }
        } else {
            System.out.println("There is no members!\n");
        }
        return employees;
    }

    public void editEmployee(Scanner input) {
        System.out.println("----------------------- Edit Employee -----------------------");
        showEditEmployees();
        System.out.println("|                      Enter 0 to exit                      |");
        System.out.println("-------------------------------------------------------------\n");

        int picked = 1;
        int tempI = 1;

        String[] strArrayMember = new String[9];
        String[] sArr = new String[employees.size()];
        Arrays.fill(sArr, "");
        while (picked != 0) {
            System.out.print("Enter number for which member you want to change info about: ");
            picked = input.nextInt();
            System.out.println();
            if (picked != 0 && picked <= employees.size()) {
                String s = String.valueOf(employees.get(picked - 1));
                String[] strArr = s.split("\n");
                for (int j = 0; j < 9; j++) {
                    sArr[picked - 1] += strArr[j] + "\n";
                    strArrayMember = sArr[picked - 1].split("\n");
                }
                for (int i = 0; i < strArrayMember.length; i++) {
                    if (i != 2) {
                        System.out.println("Nr. " + (tempI) + ": " + strArrayMember[i]);
                        tempI++;
                    }
                    String newLastMember = strArrayMember[i].substring(strArrayMember[i].indexOf(": ") + 2);
                    strArrayMember[i] = newLastMember;
                }
                System.out.println("Enter number for which info you want to change: ");
                int pickInfoF = input.nextInt();
                input.nextLine();
                switch (pickInfoF) {
                    case 1: // Firstname
                        System.out.println("Enter the new rank: ");
                        strArrayMember[0] = input.next();
                        break;
                    case 2: // Firstname
                        System.out.println("Enter new username: ");
                        strArrayMember[1] = input.next();
                        break;
                    case 3: // Lastname
                        System.out.println("Enter new password: ");
                        strArrayMember[2] = input.next();
                        break;
                    default:
                }
                Employees member = new Employees(strArrayMember[0], strArrayMember[1], strArrayMember[2]);
                employees.set(picked - 1, member);
            } else if (picked >= employees.size()) {
                System.out.println("Number " + picked + " is not a valid option\n");
            }
        }
    }

    public void showEditEmployees() {
        for (Employees s : employees) {
            System.out.printf("| Nr. %-2d | Rank: %-9s | Username: %-20s |\n", employees.indexOf(s) + 1, s.rank, s.username);
        }
        System.out.println("|-----------------------------------------------------------|");
    }

    public void showEmployee(Scanner input) {
        System.out.println("------------------------- Employees -------------------------");
        showEditEmployees();
        System.out.println("|                      Enter 0 to exit                      |");
        System.out.println("-------------------------------------------------------------\n");
    }

    /**
     * Writing member arraylist to a file
     */
    public void writeToEmployeeFile(ArrayList<Employees> employees) throws IOException {
        //sortMemberActivity();
        FileWriter writeFile = new FileWriter(new File("Files/Employees/employees"), false);
        BufferedWriter bWrite = new BufferedWriter(writeFile);

        String employeesOut = "";

        for (int i = 0; i < employees.size(); i++) {
            employeesOut += employees.get(i) + "\n";
        }
        bWrite.write(employeesOut);
        bWrite.close();
    }

    /*
        public void sortMemberActivity() {
            Employees[] employeeArray = new Employees[employees.size()];
            Employees[] tempArray = new Employees[1];
            for (int i = 0; i < employees.size(); i++) {
                employeeArray[i] = employees.get(i);
            }
            for (int i = 0; i < employees.size(); i++) {
                for (int j = i + 1; j < employeeArray.length; j++) {
                    if (employeeArray[i].activityType.compareTo(employeeArray[j].activityType) > 0) {
                        tempArray[0] = employeeArray[i];
                        employeeArray[i] = employeeArray[j];
                        employeeArray[j] = tempArray[0];
                    }
                }
                employees.set(i, employeeArray[i]);
            }
        }

     */

    public ArrayList<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employees> employees) {
        this.employees = employees;
    }
}
