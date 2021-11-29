package com.company;

public class CompetitionMember extends Member {
    String[] disciplinType = {"Front Crawl", "Breaststroke", "Butterfly", "Backstroke"};
    int[] trainingResult = {0, 0, 0, 0};
    String[] date = {null, null, null, null};

    public CompetitionMember(String activityType, String teamType, boolean status, String fName, String lName,
                             int age, String email, String address, boolean restance, String[] disciplinType, int[] trainingResult, String[] date) {
        super(activityType, teamType, status, fName, lName,
                age, email, address, restance);
        this.disciplinType = disciplinType;
        this.trainingResult = trainingResult;
        this.date = date;

    }

    @Override
    public String toString() {
        String CompetitionMemberString = "";
        for(int i = 0; i < disciplinType.length; i++) {
            CompetitionMemberString += "\n" + disciplinType[i] + ":\nBest time: " + trainingResult[i] + "\nDate: " + date[i];
        }
        return (super.toString() + "\nSwimming records:\n" + CompetitionMemberString);
    }
}
