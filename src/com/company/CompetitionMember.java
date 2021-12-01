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

    public ArrayList<CompetitionMember> createCompetitionMember(Scanner input, ArrayList<Member> members) {

        System.out.println(members);
        //MemberHandler memberhandler = new MemberHandler();
        //ArrayList<Member> arrayMemberListT = memberhandler.getMembers();

        //System.out.println(arrayMemberListT);
        System.out.println("Pick a member you want to make into a competition member");
        int answer = input.nextInt();

        System.out.println(answer);

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
