package com.company;

public class CompetitionMember extends Member {
    String disciplinType;
    String trainingResult;
    String date;

    public CompetitionMember(String activityType, String teamType, boolean status, String fName, String lName,
                             int age, String email, String address, boolean restance, String disciplinType, String trainingResult, String date) {
        super(activityType, teamType, status, fName, lName,
                age, email, address, restance);
        this.disciplinType = disciplinType;
        this.trainingResult = trainingResult;
        this.date = date;

    }

    @Override
    public String toString() {
        return (super.toString() + "\ndisciplinType: " + disciplinType + "\ntrainingResult: " + trainingResult + "\ndate: " + date);
    }
}
