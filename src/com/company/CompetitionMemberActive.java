package com.company;

public class CompetitionMemberActive extends CompetitionMember {
    String event;
    String placement;
    String eventResult;

    public CompetitionMemberActive(String activityType, String teamType, boolean status, String fName, String lName, int age,
                                   String email, String address, boolean restance, String disciplinType, String trainingResult, String date, String event, String placement, String eventResult) {
        super(activityType, teamType, status, fName, lName, age, email, address, restance, disciplinType, trainingResult, date);
        this.event = event;
        this.placement = placement;
        this.eventResult = eventResult;
    }

    @Override
    public String toString() {
        return (super.toString() + "\nevent: " + event + "\nplacement: " + placement + "\neventResult: " + eventResult);
    }
}
