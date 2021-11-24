package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
        int answer = 1;
        while (answer != 0) {
            System.out.println("""
                    *** Head menu ***
                    Enter 0 to exit program
                    Enter 1 to ---
                    Enter 2 to ---""");
            answer = scan.nextInt();
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
    }
}
