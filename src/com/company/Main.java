package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        MemberHandler memberHandler = new MemberHandler();
        Economy economy = new Economy();

        int answer = 1;
        while (answer != 0) {
            System.out.println("""
                    *** Head menu ***
                    Enter 0 for exit program
                    Enter 1 for Member Menu
                    Enter 2 for ---
                    Enter 3 for Economy Menu""");
            answer = input.nextInt();
            switch (answer) {
                case 1:
                    memberHandler.memberHandlerMenu(input);
                    writeToMemberFile(memberHandler.getMembers());
                    break;
                case 2:
                    break;
                case 3:
                    Economy.economyMenu(input);
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
}
