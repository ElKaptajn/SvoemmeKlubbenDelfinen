package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class CompetitionMember extends Member {
    String[] disciplinType = {"Front Crawl", "Breaststroke", "Butterfly", "Backstroke"};
    String[] trainingResult = {"00:00", "00:00", "00:00", "00:00"};
    String[] date = {null, null, null, null};

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

    @Override
    public String toString() {
        String CompetitionMemberString = "";
        for(int i = 0; i < disciplinType.length; i++) {
            CompetitionMemberString += "\n" + disciplinType[i] + ":\nBest time: " + trainingResult[i] + "\nDate: " + date[i] + "\n";
        }
        return (super.toString() + "\n\nSwimming records:\n" + CompetitionMemberString);
    }
}
