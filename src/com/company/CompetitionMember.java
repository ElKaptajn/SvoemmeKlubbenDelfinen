package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class CompetitionMember extends Member {
    private String[] disciplinType = {"Front Crawl", "Breaststroke", "Butterfly", "Backstroke"};
    private int[] trainingResult = {0, 0, 0, 0};
    private String[] date = {"0", "0", "0", "0"};

    ArrayList<CompetitionMember> competitionMembers = new ArrayList<>();

    public CompetitionMember(String activityType, String teamType, boolean status, String fName, String lName,
                             int age, String email, String address, boolean restance, String[] disciplinType, int[] trainingResult, String[] date) {
        super(activityType, teamType, status, fName, lName,
                age, email, address, restance);
        this.disciplinType = disciplinType;
        this.trainingResult = trainingResult;
        this.date = date;

    }
    public CompetitionMember(){
    }
                    //Til test
    public ArrayList<CompetitionMember> createCompetitionMember(Scanner input) {
        System.out.println("Enter firstname: ");
        String fName = input.next();
        System.out.println("Enter lastname: ");
        String lName = input.next();
        System.out.println("Enter age: ");
        int age = input.nextInt();
        System.out.println("Enter email: ");
        String email = input.next();
        input.nextLine();
        System.out.println("Enter address: ");
        String address = input.nextLine();
        String teamType = "None";
        String activityType = "";
        System.out.println("Enter activity form, \"1\" for Motionist, \"2\" for Competition Swimmer");
        int activityTypeChoice = input.nextInt();
        while (activityTypeChoice > 2) {
            System.out.println("Invalid number: " + activityTypeChoice);
            activityTypeChoice = input.nextInt();
        }
        if (activityTypeChoice == 1) {
            activityType = "Motionist";
        } else if (activityTypeChoice == 2) {
            activityType = "Competition Swimmer";
        }
        if ((age < 18) && (activityType.equals("Competition Swimmer"))) {
            teamType = "Junior";
        } else if (age > 18 && age < 60 && (activityType.equals("Competition Swimmer"))) {
            teamType = "Senior";
        }

        boolean status = true;
        boolean arrears = false;

        CompetitionMember competitionMember = new CompetitionMember(activityType, teamType, status, fName, lName, age, email, address, arrears,
                disciplinType, trainingResult, date);
        competitionMembers.add(competitionMember);

        System.out.println(competitionMember);

        return competitionMembers;
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
