package com.company;

import java.io.*;
import java.util.*;

public class Result {

    public void resultMenu (Scanner input, ArrayList<Member> members, ArrayList<CompetitionMember> competitionMembers) throws IOException {
        MemberHandler memberHandler = new MemberHandler();

        int answer = -1;
        while(answer != 0){
            System.out.println("""
                    *** result menu ***
                Enter 0 to exit result menu
                Enter 1 to show the top five lists
                Enter 2 to add a new result
                Enter 3 to edit an existing result
                Enter 4 to make an existing member into a competitionMember
                Enter 5 to make a new competitionMember""");
            answer = input.nextInt();
            switch(answer){
                case 0:
                    System.out.println("Returning to main menu");
                    break;
                case 1:
                    getTopFive(competitionMembers, input);
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("EDIT RESULT");
                    break;
                case 4:
                    makeMemberToCompetitionMember(input, members, competitionMembers);
                    writeToCompetitionMemberList(competitionMembers);
                    break;
                case 5:
                    memberHandler.createMember(input);
                    makeMemberToCompetitionMember(input, members, competitionMembers);
                    writeToCompetitionMemberList(competitionMembers);
                    break;
                default:
                    System.out.println("Number " + answer + " is not a valid option");
                    break;
            }
        }
    }

    public void getTopFive(ArrayList<CompetitionMember> competitionMembers, Scanner input) {

        int pickTop5 = 1;
        while (pickTop5 != 0) {
            System.out.println("""
                    *** Top 5 Menu ***
                    Enter 0 for exit top 5 list selection
                    Enter 1 for top 5 Crawl
                    Enter 2 for top 5 Breaststroke
                    Enter 3 for top 5 Butterfly
                    Enter 4 for top 5 Backstroke""");
            pickTop5 = input.nextInt();
            switch (pickTop5) {
                case 1: //Crawl
                    String[] disRes = new String[competitionMembers.size()];
                    for (int i = 0; i < competitionMembers.size(); i++){
                        disRes[i] = competitionMembers.get(i).trainingResult[0];
                    }
                    /*
                    for (int i = 0; i < competitionMembers.size(); i++) {
                        for (int j = i + 1; j < disRes.length; j++) {
                            if (disRes[i].compareTo(afhentningstidspunkt[j]) > 0) {
                                tempBestilling = bestillingsliste[i];
                                bestillingsliste[i] = bestillingsliste[j];
                                bestillingsliste[j] = tempBestilling;
                            }
                        }
                        filhaandtering.writeToBestillingsliste(bestillingsliste);
                    }

                     */

                    for (int i = 0; i < competitionMembers.size(); i++) {
                        System.out.println(competitionMembers.get(i).disciplinType[0] + " " + competitionMembers.get(i).trainingResult[0] + " " + competitionMembers.get(i).date[0]);
                    }
                    System.out.println();
                    break;
                case 2: //Breaststroke
                    for (int i = 0; i < competitionMembers.size(); i++) {
                        System.out.println(competitionMembers.get(i).disciplinType[1] + " " + competitionMembers.get(i).trainingResult[1] + " " + competitionMembers.get(i).date[1]);
                    }
                    System.out.println();
                    break;
                case 3: //Butterfly
                    for (int i = 0; i < competitionMembers.size(); i++) {
                        System.out.println(competitionMembers.get(i).disciplinType[2] + " " + competitionMembers.get(i).trainingResult[2] + " " + competitionMembers.get(i).date[2]);
                    }
                    System.out.println();
                    break;
                case 4: //Backstroke
                    for (int i = 0; i < competitionMembers.size(); i++) {
                        System.out.println(competitionMembers.get(i).disciplinType[3] + " " + competitionMembers.get(i).trainingResult[3] + " " + competitionMembers.get(i).date[3]);
                    }
                    System.out.println();
                    break;
                default:
            }
        }
       /* String[] disTypeArray = new String[4];
        int[] intArr = new int[4];
        for (int i = 0; i < competitionMembers.size(); i++) {


            if (competitionMembers.get(i).disciplinType[i].equals("Crawl") && !competitionMembers.get(i).disciplinType[i].equals("null")) {
                disTypeArray[i] = competitionMembers.get(i).trainingResult[i];
                String s = String.valueOf(disTypeArray[i]);
                String[] strArr = s.split(":");

                intArr[i] = Integer.parseInt(strArr[i]);
                Arrays.sort(intArr);

            }
            if (competitionMembers.get(i).disciplinType[i].equals("Breaststroke") && !competitionMembers.get(i).disciplinType[i].equals("null")) {
                disTypeArray[i] = competitionMembers.get(i).trainingResult[i];
                String s = String.valueOf(disTypeArray[i]);
                String[] strArr = s.split(":");

                intArr[i] = Integer.parseInt(strArr[i]);
                Arrays.sort(intArr);

            }
            if (competitionMembers.get(i).disciplinType[i].equals("Butterfly") && !competitionMembers.get(i).disciplinType[i].equals("null")) {
                disTypeArray[i] = competitionMembers.get(i).trainingResult[i];
                String s = String.valueOf(disTypeArray[i]);
                String[] strArr = s.split(":");

                intArr[i] = Integer.parseInt(strArr[i]);
                Arrays.sort(intArr);

            }
            if (competitionMembers.get(i).disciplinType[i].equals("Backstroke") && !competitionMembers.get(i).disciplinType[i].equals("null")) {
                disTypeArray[i] = competitionMembers.get(i).trainingResult[i];
                String s = String.valueOf(disTypeArray[i]);
                String[] strArr = s.split(":");

                intArr[i] = Integer.parseInt(strArr[i]);
                Arrays.sort(intArr);

            }
            System.out.println(Arrays.toString(disTypeArray));

            System.out.println(Arrays.toString(intArr));
        }*/
    }
    public void addResult(){

    }
    public void editResult(){

    }

    public void makeMemberToCompetitionMember(Scanner input, ArrayList<Member> members, ArrayList<CompetitionMember> competitionMembers) {
        int counter = 1;
        for (Member m: members) {
            System.out.println("Nr." + counter + "\n" + m + "\n********************************");
            counter++;
        }
        System.out.print("Pick a member from the list above, that you want to make into a competition member.\nThe members nr: ");
        int answer = input.nextInt();
        Member changingMember = members.get(answer-1);
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

        System.out.println("Do you want to add a result for the new competition member?\nType 1 for yes or 2 for no");
        int addResultAnswer = input.nextInt();
        if(addResultAnswer == 1) {
            System.out.println("""
                    Which Swimming discipline do you want to add a new time to?
                    Type 1 for Crawl
                    Type 2 for Breaststroke
                    Type 3 for Butterfly
                    Type 4 for Backstroke""");

            String stringAnswer;
            boolean timeTestAnswer;
            answer = input.nextInt();
            switch (answer) {
                case 1:
                    System.out.print("New best time for Crawl (MUST be written in this format: xx:xx): ");
                    stringAnswer = input.next();
                    timeTestAnswer = timeTester(competitionMember.trainingResult[0], stringAnswer);
                    if (!timeTestAnswer) {
                        System.out.println("the time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[0]);
                    } else {
                        competitionMember.trainingResult[0] = stringAnswer;
                        System.out.print("\nDate that the new record was set: ");
                        stringAnswer = input.next();
                        competitionMember.date[0] = stringAnswer;
                    }
                    break;
                case 2:
                    System.out.print("New best time for Breaststroke (MUST be written in this format: xx:xx): ");
                    stringAnswer = input.next();
                    timeTestAnswer = timeTester(competitionMember.trainingResult[1], stringAnswer);
                    if (!timeTestAnswer) {
                        System.out.println("the time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[1]);
                    } else {
                        competitionMember.trainingResult[1] = stringAnswer;
                        System.out.print("\nDate that the new record was set: ");
                        stringAnswer = input.next();
                        competitionMember.date[1] = stringAnswer;
                    }
                    break;
                case 3:
                    System.out.print("New best time for Butterfly (MUST be written in this format: xx:xx): ");
                    stringAnswer = input.next();
                    timeTestAnswer = timeTester(competitionMember.trainingResult[2], stringAnswer);
                    if (!timeTestAnswer) {
                        System.out.println("the time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[2]);
                    } else {
                        competitionMember.trainingResult[2] = stringAnswer;
                        System.out.print("\nDate that the new record was set: ");
                        stringAnswer = input.next();
                        competitionMember.date[2] = stringAnswer;
                    }
                    break;
                case 4:
                    System.out.print("New best time for Backstroke (MUST be written in this format: xx:xx): ");
                    stringAnswer = input.next();
                    timeTestAnswer = timeTester(competitionMember.trainingResult[3], stringAnswer);
                    if (!timeTestAnswer) {
                        System.out.println("The time " + stringAnswer + " is not faster than the existing record of " + competitionMember.trainingResult[3]);
                    } else {
                        competitionMember.trainingResult[3] = stringAnswer;
                        System.out.print("\nDate that the new record was set: ");
                        stringAnswer = input.next();
                        competitionMember.date[3] = stringAnswer;
                    }
                    break;
                default:
                    System.out.println("The number " + answer + " is not a valid option");
            }
            competitionMembers.add(competitionMember);
        }else if (addResultAnswer == 2){
            competitionMembers.add(competitionMember);
        }else {
            System.out.println("Wrong input, please try again...");
        }
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
        String tempCompetitionMember = "";
        for(int i = 0; i < competitionMembers.size(); i++){
            if (competitionMembers.get(i).status){
                tempCompetitionMember += "Active, ";
            }else{
                tempCompetitionMember += "Passive, ";
            }
            tempCompetitionMember += competitionMembers.get(i).activityType + ", ";
            tempCompetitionMember += competitionMembers.get(i).teamType + ", ";
            tempCompetitionMember += competitionMembers.get(i).fName + ", ";
            tempCompetitionMember += competitionMembers.get(i).lName + ", ";
            tempCompetitionMember += competitionMembers.get(i).age + ", ";
            tempCompetitionMember += competitionMembers.get(i).email + ", ";
            tempCompetitionMember += competitionMembers.get(i).address + ", ";
            if (competitionMembers.get(i).arrears){
                tempCompetitionMember += "Yes, ";
            }else{
                tempCompetitionMember += "No, ";
            }
            tempCompetitionMember += competitionMembers.get(i).disciplinType[0] + " " + competitionMembers.get(i).disciplinType[1] + " "
                    + competitionMembers.get(i).disciplinType[2] + " " + competitionMembers.get(i).disciplinType[3] + ", ";
            tempCompetitionMember += competitionMembers.get(i).trainingResult[0] + " " + competitionMembers.get(i).trainingResult[1] + " "
                    + competitionMembers.get(i).trainingResult[2] + " " + competitionMembers.get(i).trainingResult[3] + ", ";
            tempCompetitionMember += competitionMembers.get(i).date[0] + " " + competitionMembers.get(i).date[1] + " "
                    + competitionMembers.get(i).date[2] + " " + competitionMembers.get(i).date[3];

            System.out.println(tempCompetitionMember);
            writer.write(tempCompetitionMember + "\n");

            tempCompetitionMember = ""; // til at nulstille tempCompetitionMember, inden det starter på det næste member.
        }
        writer.close();
    }

    public void updateCompetitionMemberList(ArrayList<CompetitionMember> competitionMembers) throws IOException {
        Scanner reader = new Scanner(new File("Files/CompetitionMemberList"));

        while (reader.hasNextLine()){
            String[] splitArray = reader.nextLine().split(", ");
            if (splitArray[0].equals("Active")){
                splitArray[0] = "true";
            } else {
                splitArray[0] = "false";
            }
            if (splitArray[8].equals("Yes")){
                splitArray[8] = "true";
            } else {
                splitArray[8] = "false";
            }

            String disciplinTypeStringTemp = splitArray[9];
            String[] disciplinTypeArrayTemp = disciplinTypeStringTemp.split(" ");
            String[] disciplinTypeArray = {disciplinTypeArrayTemp[0], disciplinTypeArrayTemp[1], disciplinTypeArrayTemp[2], disciplinTypeArrayTemp[3]};
            String trainingResultStringTemp = splitArray[10];
            String[] trainingResultArrayTemp = trainingResultStringTemp.split(" ");
            String[] trainingResultArray = {trainingResultArrayTemp[0], trainingResultArrayTemp[1], trainingResultArrayTemp[2], trainingResultArrayTemp[3]};
            String dateStringTemp = splitArray[11];
            String[] dateArrayTemp = dateStringTemp.split(" ");
            String[] dateArray = {dateArrayTemp[0], dateArrayTemp[1], dateArrayTemp[2], dateArrayTemp[3]};

            CompetitionMember tempCompetitionMember = new CompetitionMember(Boolean.parseBoolean(splitArray[0]), splitArray[1],
                    splitArray[2], splitArray[3], splitArray[4], Integer.parseInt(splitArray[5]), splitArray[6], splitArray[7], Boolean.parseBoolean(splitArray[8]),
                    disciplinTypeArray, trainingResultArray, dateArray);

            competitionMembers.add(tempCompetitionMember);
        }
    }
}
