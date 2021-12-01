package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class CompetitionMember extends Member {
    private String[] disciplinType = {"Front Crawl", "Breaststroke", "Butterfly", "Backstroke"};
    private int[] trainingResult = {0, 0, 0, 0};
    private String[] date = {"0", "0", "0", "0"};

    ArrayList<CompetitionMember> competitionMembers = new ArrayList<>();

    public CompetitionMember(boolean status, String activityType, String teamType, String fName, String lName,
                             int age, String email, String address, boolean restance, String[] disciplinType, int[] trainingResult, String[] date) {
        super(status, activityType, teamType, fName, lName,
                age, email, address, restance);
        this.disciplinType = disciplinType;
        this.trainingResult = trainingResult;
        this.date = date;

    }
    public CompetitionMember(){
    }
                    //Til test
    // evt. lav det så man kalder denne metode fra createmember i en if competetive statement... som tager de allerede indtastede
    // informationer med over og lave dem om til et CompetitionMember objekt istedet for et member objekt. Husk evt. break sp den ikke hopper tilbage i metoden?
    public ArrayList<CompetitionMember> createCompetitionMember(Scanner input, Member member) {

        CompetitionMember competitionMember = new CompetitionMember(status, activityType, teamType, fName, lName, age, email, address, arrears,
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
