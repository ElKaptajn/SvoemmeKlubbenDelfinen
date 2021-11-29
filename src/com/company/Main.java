package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	    Scanner input = new Scanner(System.in);
        MemberHandler memberHandler = new MemberHandler();
        int answer = 1;
        while (answer != 0) {
            System.out.println("""
                    *** Head menu ***
                    Enter 0 to exit program
                    Enter 1 to Member Menu
                    Enter 2 to ---""");
            answer = input.nextInt();
            switch (answer) {
                case 1:
                    memberHandler.memberHandlerMenu(input);
                    break;
                case 2:
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
}
