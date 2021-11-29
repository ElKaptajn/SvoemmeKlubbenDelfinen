package com.company;

import java.io.IOException;
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
}
