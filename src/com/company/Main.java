package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        MemberHandler memberHandler = new MemberHandler();
        //Economy economy = new Economy();
        Result result = new Result();
        updateMemberArrayList(memberHandler.getMembers());
        result.updateCompetitionMemberList(memberHandler.getCompetitionMembers());
        int answer = 1;
        while (answer != 0) {
            System.out.println("""
                    *** Head menu ***
                    Enter 0 for exit program
                    Enter 1 for Member Menu
                    Enter 2 for Result Menu
                    Enter 3 for Economy Menu""");
            answer = input.nextInt();
            switch (answer) {
                case 1:
                    memberHandler.memberHandlerMenu(input);
                    writeToMemberFile(memberHandler.getMembers());
                    break;
                case 2:
                    result.resultMenu(input, memberHandler.getMembers(), memberHandler.getCompetitionMembers());
                    break;
                case 3:
                    //Economy.economyMenu(input);
                    break;
                default:
                    if (answer == 0) {
                        System.out.println("Thanks for using the program!");
                    } else {
                        System.out.println("Number " + answer + " is not a valid option");
                    }
                    break;

            }
        }
    }
    /**
     * Writing member arraylist to a file
     */
    public static void writeToMemberFile(ArrayList<Member> members) throws IOException {
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
            Member member = new Member(Boolean.parseBoolean(memberInfo[0]), memberInfo[1], memberInfo[2], memberInfo[3], memberInfo[4], Integer.parseInt(memberInfo[5]), memberInfo[6], memberInfo[7], Boolean.parseBoolean(memberInfo[8]));
            members.add(member);
        }
        readMember.close();
    }
}
