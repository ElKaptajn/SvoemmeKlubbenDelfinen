package com.company;

import java.util.*;

/**
 * @author Thomas
 * @author Philip
 */

public class MemberHandler {
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<CompetitionMember> competitionMembers = new ArrayList<>();

    public void memberHandlerMenu(Scanner input) {
        System.out.println("""
                *** Member menu ***
                Enter 0 to exit program
                Enter 1 to Create new member
                Enter 2 to Delete member
                Enter 3 to Edit member
                Enter 4 to show member""");
        int answer = input.nextInt();
        switch (answer) {
            case 1 -> createMember(input);
            case 2 -> deleteMember(input);
            case 3 -> editMember(input);
            case 4 -> showMember(input);
            default -> System.out.println("Number " + answer + " is not a valid option");
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
        input.nextLine();
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
        } else if (age >= 18 && age < 60 && (activityType.equals("Competition Swimmer"))) {
            teamType = "Senior";
        }

        boolean status = true;
        boolean arrears = false;

        Member member = new Member(status, activityType, teamType, fName, lName, age, email, address, arrears);
        members.add(member);
        System.out.println(members);

        return members;
    }

    public ArrayList<Member> deleteMember(Scanner input) {
        if (members.size() >= 1) {
            for (int i = 0; i < members.size(); i++) {
                System.out.printf("Nr. %-2d: %s %b \n", (i + 1), members.get(i).fName, members.get(i).arrears);
            }
            System.out.println("Enter corresponding number for removing: ");
            int removeChoice = input.nextInt();
            members.remove(removeChoice - 1);
        } else {
            System.out.println("There is no members!\n");
        }
        return members;
    }

    public void editMember(Scanner input) {
        showEditMember();

        System.out.println("Enter number for which member you want to change info about: ");
        int picked = input.nextInt();
        int tempI = 1;

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
                //boolean arrears;
                //arrears = arrearsChoice != 2;
                if (arrearsChoice == 1) {
                    strArrayMember[8] = "true";
                } else {
                    strArrayMember[8] = "false";
                }
                //strArrayMember[8] = String.valueOf(arrears);
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

        Member member = new Member(Boolean.parseBoolean(strArrayMember[0]), strArrayMember[1], strArrayMember[2], strArrayMember[3], strArrayMember[4], Integer.parseInt(strArrayMember[5]), strArrayMember[6], strArrayMember[7], Boolean.parseBoolean(strArrayMember[8]));
        members.set(picked - 1, member);
    }

    public void showEditMember() {
        for (Member s : members) {
            System.out.printf("Nr. %-2d: name: %s, email: %s \n", members.indexOf(s) + 1, s.fName, s.email);
        }
    }

    public void showMember(Scanner input) {
        showEditMember();
        System.out.println("Enter number for which member you want to see: ");
        int choice = input.nextInt();
        System.out.println(members.get(choice - 1) + "\n");
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
