package com.company;

import java.io.*;
import java.util.*;

public class Result  {

    public static void resultMenu (Scanner input) {

        CompetitionMember competitionMember = new CompetitionMember();

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
                    //Tag fra fil eller ARRAY?
                    break;
                case 2:
                    System.out.println("ADD RESULT");
                    competitionMember.createCompetitionMember(input, member);
                    //Skal vi lave forskellige metoder til at lave de forskellige typer af members? eller kan vi samle dem på en smart måde?
                    break;
                case 3:
                    System.out.println("EDIT RESULT");
                    //Tilføj: Kan kun edit hvis det nye resultat er lavere end det der står det i forvejen
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
    public void updateResult(){

    }

}
