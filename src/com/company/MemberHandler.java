package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author Thomas
 * @author Philip
 */

public class MemberHandler {
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<CompetitionMember> competitionMembers = new ArrayList<>();

    public void memberHandlerMenu(Scanner input) throws IOException {
        int answer = 1;
        while (answer != 0) {
            System.out.println("""
                    ---------- Member menu ----------
                    | Enter 0 to exit Member menu   |
                    | Enter 1 to Create new member  |
                    | Enter 2 to Delete member      |
                    | Enter 3 to Edit member        |
                    | Enter 4 to show member        |
                    ---------------------------------""");
            answer = input.nextInt();
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
                case 4:
                    showMember(input);
                    break;
                default:
                    if (answer == 0) {
                        break;
                    } else {
                        System.out.println("Number " + answer + " is not a valid option");
                    }
            }
            writeToMemberFile(members);
        }
    }

    public ArrayList<Member> createMember(Scanner input) {
        System.out.println("--------------- Create Member ---------------");
        System.out.print("| Enter firstname: ");
        String fName = input.next();
        System.out.print("| Enter lastname: ");
        String lName = input.next();
        System.out.print("| Enter age: ");
        int age = input.nextInt();
        System.out.print("| Enter email: ");
        String email = input.next();
        input.nextLine();
        System.out.print("| Enter address: ");
        String address = input.nextLine();
        String teamType = "None";
        String activityType = "";
        System.out.print("| Enter activity form, \"1\" for Motionist, \"2\" for Competition Swimmer: ");
        int activityTypeChoice = input.nextInt();
        System.out.println("---------------------------------------------");
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
        } else if (age >= 18 && age < 60 && (activityType.equals("Competition Swimmer"))) {
            teamType = "Senior";
        }
        boolean status = true;
        boolean arrears = false;

        Member member = new Member(status, activityType, teamType, fName, lName, age, email, address, arrears);
        members.add(member);

        return members;
    }

    public ArrayList<Member> deleteMember(Scanner input) {
        if (members.size() >= 1) {
            System.out.println("-------- Delete Member --------");
            for (int i = 0; i < members.size(); i++) {
                System.out.printf("| Nr. %-2d | %-7s %-10s |\n", (i + 1), members.get(i).fName, members.get(i).lName);
            }
            System.out.println("-------------------------------");
            System.out.println("|       Enter 0 to exit       |");
            System.out.println("-------------------------------");
            System.out.println("Enter corresponding number for removing: ");
            int removeChoice = input.nextInt();
            if (removeChoice != 0) {
                members.remove(removeChoice - 1);
            }
        } else {
            System.out.println("There is no members!\n");
        }
        return members;
    }

    public void editMember(Scanner input) {
        System.out.println("------------------------ Edit member ------------------------");
        showEditMember();
        System.out.println("|                      Enter 0 to exit                      |");
        System.out.println("-------------------------------------------------------------\n");

        int picked = 1;
        int tempI = 1;

        String[] strArrayMember = new String[9];
        String[] sArr = new String[members.size()];
        Arrays.fill(sArr, "");
        while (picked != 0) {
            System.out.print("Enter number for which member you want to change info about: ");
            picked = input.nextInt();
            System.out.println();
            if (picked != 0 && picked <= members.size()) {
                String s = String.valueOf(members.get(picked - 1));
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
                    case 1: // Status
                        System.out.println("Enter new status, '1' for active and '2' for passive: ");
                        int statusChoice = input.nextInt();
                        boolean status;
                        status = statusChoice != 2;
                        strArrayMember[0] = String.valueOf(status);
                        break;
                    case 2: // Activity form
                        System.out.println("Enter new activity form, \"1\" for Motionist, \"2\" for Competition Swimmer");
                        int activityTypeChoice = input.nextInt();
                        while (activityTypeChoice > 2) {
                            System.out.println("Invalid number: " + activityTypeChoice);
                            activityTypeChoice = input.nextInt();
                        }
                        if (activityTypeChoice == 1) {
                            strArrayMember[1] = "Motionist";
                        } else if (activityTypeChoice == 2) {
                            strArrayMember[1] = "Competition Swimmer";
                        }
                        break;
                    case 3: // Firstname
                        System.out.println("Enter new first name: ");
                        strArrayMember[3] = input.next();
                        break;
                    case 4: // Lastname
                        System.out.println("Enter new last name: ");
                        strArrayMember[4] = input.next();
                        break;
                    case 5: // Age
                        System.out.println("Enter new age: ");
                        strArrayMember[5] = String.valueOf(input.nextInt());
                        break;
                    case 6: // E-mail
                        System.out.println("Enter new email: ");
                        strArrayMember[6] = input.next();
                        break;
                    case 7: // Address
                        System.out.println("Enter new address: ");
                        strArrayMember[7] = input.nextLine();
                        break;
                    case 8: // Arrears
                        System.out.println("Enter new arrears, '1' for true and '2' for false: ");
                        int arrearsChoice = input.nextInt();
                        boolean arrears;
                        arrears = arrearsChoice != 2;
                        strArrayMember[8] = String.valueOf(arrears);
                        break;
                    default:
                }
                if ((Integer.parseInt(strArrayMember[5]) < 18) && (strArrayMember[1].equals("Competition Swimmer"))) {
                    strArrayMember[2] = "Junior";
                } else if ((Integer.parseInt(strArrayMember[5]) >= 18) && ((Integer.parseInt(strArrayMember[5])) < 60) && (strArrayMember[1].equals("Competition Swimmer"))) {
                    strArrayMember[2] = "Senior";
                } else if (strArrayMember[1].equals("Competition Swimmer") || strArrayMember[1].equals("Motionist")) {
                    strArrayMember[2] = "None";
                    strArrayMember[1] = "Motionist";
                }
                if (strArrayMember[0].equals("Active")) {
                    strArrayMember[0] = "true";
                } else if (strArrayMember[0].equals("Passive")) {
                    strArrayMember[0] = "false";
                }
                if (strArrayMember[8].equals("Yes")) {
                    strArrayMember[8] = "true";
                } else if (strArrayMember[8].equals("No")) {
                    strArrayMember[8] = "false";
                }

                Member member = new Member(Boolean.parseBoolean(strArrayMember[0]), strArrayMember[1], strArrayMember[2], strArrayMember[3], strArrayMember[4],
                        Integer.parseInt(strArrayMember[5]), strArrayMember[6], strArrayMember[7], Boolean.parseBoolean(strArrayMember[8]));
                members.set(picked - 1, member);
            } else if (picked >= members.size()){
                System.out.println("Number " + picked + " is not a valid option\n");
            }
        }
    }

    public void showEditMember() {
        for (Member s : members) {
            System.out.printf("| Nr. %-2d | Name: %-8s | E-mail: %-23s |\n", members.indexOf(s) + 1, s.fName, s.email);
        }
        System.out.println("|-----------------------------------------------------------|");
    }

    public void showMember(Scanner input) {
        System.out.println("-------------------------- Members --------------------------");
        showEditMember();
        System.out.println("|                      Enter 0 to exit                      |");
        System.out.println("-------------------------------------------------------------\n");
        int choice = 1;
        while (choice != 0) {
            System.out.print("Enter number for which member you want to see: ");
            choice = input.nextInt();
            if (choice != 0 && choice <= members.size()) {
                String myStatus = String.valueOf(members.get(choice - 1).status);
                String myArrears = String.valueOf(members.get(choice - 1).arrears);
                if (myStatus.equals("true")) {
                    myStatus = "Active";
                } else if (myStatus.equals("false")) {
                    myStatus = "Passive";
                }
                if (myArrears.equals("true")) {
                    myArrears = "Yes";
                } else if (myArrears.equals("false")) {
                    myArrears = "No";
                }
                System.out.println("--------------------------------------");
                System.out.printf("""
                                | Status       : %-19s |
                                | Activity form: %-12s |
                                | Team         : %-19s |
                                | First name   : %-19s |
                                | Last name    : %-19s |
                                | Age          : %-19d |
                                | E-mail       : %-19s |
                                | Address      : %-19s |
                                | Arrears      : %-19s |
                                """,
                        myStatus, members.get(choice - 1).activityType, members.get(choice - 1).teamType,
                        members.get(choice - 1).fName, members.get(choice - 1).lName, members.get(choice - 1).age,
                        members.get(choice - 1).email, members.get(choice - 1).address, myArrears);
                System.out.println("--------------------------------------\n");
            } else if (choice >= members.size()){
                System.out.println("\nNumber " + choice + " is not a valid option\n");
            }
        }
    }

    /**
     * Writing member arraylist to a file
     */
    public void writeToMemberFile(ArrayList<Member> members) throws IOException {
        sortMemberActivity();
        FileWriter writeFile = new FileWriter(new File("Files/MemberList"), false);
        BufferedWriter bWrite = new BufferedWriter(writeFile);

        String membersOut = "";
        String[] sArr = new String[members.size()];
        Arrays.fill(sArr, "");

        for (int i = 0; i < members.size(); i++) {
            String s = String.valueOf(members.get(i));
            String[] strArr = s.split("\n");
            for (int j = 0; j < 9; j++) {
                String newLastMember = strArr[j].substring(strArr[j].indexOf(": ") + 2);
                sArr[i] += newLastMember + ", ";
            }
            membersOut += sArr[i] + "\n";
        }
        bWrite.write(membersOut);
        bWrite.close();
    }

    public void sortMemberActivity(){
        Member[] memberArray = new Member[members.size()];
        Member[] tempArray = new Member[1];
        for (int i = 0; i < members.size(); i++) {
            memberArray[i] = members.get(i);
        }
        for (int i = 0; i < members.size(); i++) {
            for (int j = i + 1; j < memberArray.length; j++) {
                if (memberArray[i].activityType.compareTo(memberArray[j].activityType) > 0) {
                    tempArray[0] = memberArray[i];
                    memberArray[i] = memberArray[j];
                    memberArray[j] = tempArray[0];
                }
            }
            members.set(i, memberArray[i]);
        }
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void setCompetitionMembers(ArrayList<CompetitionMember> CompetitionMember) {
        this.competitionMembers = competitionMembers;
    }
    public ArrayList<CompetitionMember> getCompetitionMembers() {
        return competitionMembers;
    }
}