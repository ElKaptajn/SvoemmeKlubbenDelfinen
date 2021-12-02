package com.company;

import java.io.*;
import java.util.*;

public class Result  {

    public void resultMenu (Scanner input, ArrayList<Member> members, ArrayList<CompetitionMember> competitionMembers) throws IOException {

        int answer = -1;
        while(answer != 0){
            System.out.println("""
                    *** result menu ***
                Enter 0 to exit result menu
                Enter 1 to show the top five lists
                Enter 2 to add a new result
                Enter 3 to edit an existing result
                Enter 4 to make an existing member into a competitionMember""");
            answer = input.nextInt();
            switch(answer){
                case 0:
                    System.out.println("Returning to main menu");
                    break;
                case 1:
                    System.out.println("TOP 5 MENU");
                    writeToCompetitionMemberList(competitionMembers);
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("EDIT RESULT");
                    break;
                case 4:
                    makeMemberToCompetitionMember(input, members, competitionMembers);
                    break;
                case 5:

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
    //Mangler delete fra member arrayet og metoden skal nok splittets op i edit og create.
    //Mangler at bliver gemt i fil og hentet fra fil
    //WORK IN PROGRESS...

    public void makeMemberToCompetitionMember(Scanner input, ArrayList<Member> members, ArrayList<CompetitionMember> competitionMembers) {
        ArrayList<Member> arrayMemberListT = members;
        int counter = 1;
        for (Member m: arrayMemberListT) {
            System.out.println("Nr." + counter + "\n" + m + "\n********************************");
            counter++;
        }
        System.out.print("Pick a member from the list above, that you want to make into a competition member.\nThe members nr: ");
        int answer = input.nextInt();
        Member changingMember = arrayMemberListT.get(answer-1);
        members.remove(answer-1);

        CompetitionMember competitionMember = new CompetitionMember();

        competitionMember.status = changingMember.status;
        competitionMember.activityType = changingMember.activityType;
        competitionMember.teamType = changingMember.teamType;
        competitionMember.fName = changingMember.fName;
        competitionMember.lName = changingMember.lName;
        competitionMember.age = changingMember.age;
        competitionMember.email = changingMember.email;
        competitionMember.address = changingMember.address;
        competitionMember.arrears = changingMember.arrears;

        System.out.println("""
                Which Swimming discipline do you want to add a new time to?
                Type 1 for Crawl
                Type 2 for Breaststroke
                Type 3 for Butterfly
                Type 4 for Backstroke""");

       String stringAnswer;
        boolean timeTestAnswer;
        answer = input.nextInt();
        switch (answer){
            case 1:
                System.out.print("New best time for Crawl (MUST be written in this format: xx:xx): ");
                stringAnswer = input.next();
                timeTestAnswer = timeTester(competitionMember.trainingResult[0], stringAnswer);
                if(!timeTestAnswer){
                    System.out.println("the time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[0]);
                    break;
                }else {
                    competitionMember.trainingResult[0] = stringAnswer;
                    System.out.print("\nDate that the new record was set: ");
                    stringAnswer = input.next();
                    competitionMember.date[0] = stringAnswer;
                    break;
                }
            case 2:
                System.out.print("New best time for Breaststroke (MUST be written in this format: xx:xx): ");
                stringAnswer = input.next();
                timeTestAnswer = timeTester(competitionMember.trainingResult[1], stringAnswer);
                if(!timeTestAnswer){
                    System.out.println("the time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[1]);
                    break;
                }else {
                    competitionMember.trainingResult[1] = stringAnswer;
                    System.out.print("\nDate that the new record was set: ");
                    stringAnswer = input.next();
                    competitionMember.date[1] = stringAnswer;
                    break;
                }
            case 3:
                System.out.print("New best time for Butterfly (MUST be written in this format: xx:xx): ");
                stringAnswer = input.next();
                timeTestAnswer = timeTester(competitionMember.trainingResult[2], stringAnswer);
                if(!timeTestAnswer){
                    System.out.println("the time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[2]);
                    break;
                }else {
                    competitionMember.trainingResult[2] = stringAnswer;
                    System.out.print("\nDate that the new record was set: ");
                    stringAnswer = input.next();
                    competitionMember.date[2] = stringAnswer;
                    break;
                }
            case 4:
                System.out.print("New best time for Backstroke (MUST be written in this format: xx:xx): ");
                stringAnswer = input.next();
                timeTestAnswer = timeTester(competitionMember.trainingResult[3], stringAnswer);
                if(!timeTestAnswer){
                    System.out.println("The time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[3]);
                    break;
                }else {
                    competitionMember.trainingResult[3] = stringAnswer;
                    System.out.print("\nDate that the new record was set: ");
                    stringAnswer = input.next();
                    competitionMember.date[3] = stringAnswer;
                    break;
                }
            default:
                System.out.println("The number " + answer + " is not a valid option");
        }

        competitionMembers.add(competitionMember);
    }

    //Tester hvilken tid der er lavest. Stringen skal være i formatet: xx:xx.
    public boolean timeTester(String oldTimeString, String newTimeString){
        if(oldTimeString == "00:00") {
            return true;
        }else {
            String oldTimeMinString = oldTimeString.substring(0, oldTimeString.indexOf(":"));
            String oldTimeSecString = oldTimeString.substring(oldTimeString.indexOf(":") + 1);
            int oldTimeMin = Integer.parseInt(oldTimeMinString);
            int oldTimeSec = Integer.parseInt(oldTimeSecString);

            String newTimeMinString = newTimeString.substring(0, newTimeString.indexOf(":"));
            String newTimeSecString = newTimeString.substring(newTimeString.indexOf(":") + 1);
            int newTimeMin = Integer.parseInt(newTimeMinString);
            int newTimeSec = Integer.parseInt(newTimeSecString);

            if(newTimeMin <= oldTimeMin){
                if(newTimeSec < oldTimeSec){
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
    }
    public void writeToCompetitionMemberList(ArrayList<CompetitionMember> competitionMembers) throws IOException {
        FileWriter writer = new FileWriter("Files/CompetitionMemberList");
        for (CompetitionMember c : competitionMembers){
            writer.write(c + System.lineSeparator());
        }
        writer.close();

    }
    public void updateCompetitionMemberList()throws IOException {
        Scanner input = new Scanner("Files/CompetitionMemberList");
        boolean status = false;
        String activityType = "";
        String teamType = "";
        String fName = "";
        String lName = "";
        int age = 0;
        String email = "";
        String address = "";
        boolean arrears = false;
        String[] disciplinType = {"Front Crawl", "Breaststroke", "Butterfly", "Backstroke"};
        String[] trainingResult = {"00:00", "00:00", "00:00", "00:00"};
        String[] date = {null, null, null, null};


    }
}
