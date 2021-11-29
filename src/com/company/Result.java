package com.company;

import java.io.*;
import java.util.*;

public class Result {

    public static void resultMenu (Scanner input) {
        int answer = -1;
        while(answer != 0){
            System.out.println("""
                    *** result menu ***
                Enter 0 to exit result menu
                Enter 1 to show the top five lists
                Enter 2 to add a new result
                Enter 3 to edit an existing result""");
            answer = input.nextInt();
            switch(answer){
                case 0:
                    System.out.println("Returning to main menu");
                    break;
                case 1:
                    System.out.println("TOP 5 MENU");
                    break;
                case 2:
                    System.out.println("ADD RESULT");
                    break;
                case 3:
                    System.out.println("EDIT RESULT");
                    break;
                default:
                    System.out.println("Number " + answer + " is not a valid option");
                    break;
            }
        }
    }

    public void getTopFive(){

    }
    public void addResult(){

    }
    public void editResult(){

    }

}
