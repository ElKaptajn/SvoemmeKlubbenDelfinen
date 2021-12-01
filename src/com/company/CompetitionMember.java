package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class CompetitionMember extends Member {
    private String[] disciplinType = {"Front Crawl", "Breaststroke", "Butterfly", "Backstroke"};
    private String[] trainingResult = {"06:23", "0", "0", "0"}; // sat til 06:23 for at kunne teste timetester metoden
    private String[] date = {"0", "0", "0", "0"};

    ArrayList<CompetitionMember> competitionMembers = new ArrayList<>();

    public CompetitionMember(boolean status, String activityType, String teamType, String fName, String lName,
                             int age, String email, String address, boolean restance, String[] disciplinType, String[] trainingResult, String[] date) {
        super(status, activityType, teamType, fName, lName,
                age, email, address, restance);
        this.disciplinType = disciplinType;
        this.trainingResult = trainingResult;
        this.date = date;

    }
    public CompetitionMember(){
    }

                //Mangler delete fra member arrayet og metoden skal nok splittets op i edit og create.
                //Skal rykkes til member handler og/eller result klassen
                //Mangler at bliver gemt i fil og hentet fra fil
                //WORK IN PROGRESS...
    public void createCompetitionMember(Scanner input, ArrayList<Member> members) {
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

        CompetitionMember competitionMember = new CompetitionMember(status, activityType, teamType, fName, lName, age, email, address, arrears,
                disciplinType, trainingResult, date);
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
                timeTestAnswer = timeTester(trainingResult[0], stringAnswer);
                if(!timeTestAnswer){
                    System.out.println("the time " + stringAnswer + " is not faster than the existing record of " + trainingResult[0]);
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
                timeTestAnswer = timeTester(trainingResult[1], stringAnswer);
                if(!timeTestAnswer){
                    System.out.println("the time " + stringAnswer + " is not faster than the existing record of " + trainingResult[1]);
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
                timeTestAnswer = timeTester(trainingResult[2], stringAnswer);
                if(!timeTestAnswer){
                    System.out.println("the time " + stringAnswer + " is not faster than the existing record of " + trainingResult[2]);
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
                timeTestAnswer = timeTester(trainingResult[3], stringAnswer);
                if(!timeTestAnswer){
                    System.out.println("The time " + stringAnswer + " is not faster than the existing record of " + trainingResult[3]);
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
        //System.out.println("\n" + competitionMember); //TIL TEST
    }
            //Tester hvilken tid der er lavest. Stringen skal være i formatet: xx:xx.
    public boolean timeTester(String oldTimeString, String newTimeString){
        if(!oldTimeString.contains(":")) {
            return false;
        }else if(oldTimeString == "0") {
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

    @Override
    public String toString() {
        String CompetitionMemberString = "";
        for(int i = 0; i < disciplinType.length; i++) {
            CompetitionMemberString += "\n" + disciplinType[i] + ":\nBest time: " + trainingResult[i] + "\nDate: " + date[i] + "\n";
        }
        return (super.toString() + "\n\nSwimming records:\n" + CompetitionMemberString);
    }
}
