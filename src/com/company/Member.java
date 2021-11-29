package com.company;

import java.util.EnumSet;

public class Member {
    String activityType;
    String teamType;
    boolean status;
    String fName;
    String lName;
    int age;
    String email;
    String address;
    boolean restance;
    //restanceType {junior, senior, pensioner, passiv}

    public Member(String activityType, String teamType, boolean status, String fName, String lName,
                  int age, String email, String address, boolean restance) {
        this.activityType = activityType;
        this.teamType = teamType;
        this.status = status;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.email = email;
        this.address = address;
        this.restance = restance;
    }

    @Override
    public String toString() {
        String myStatus;
        String myRestance;
        if (status){
            myStatus = "Active";
        }else{myStatus = "Passiv";}
        if (restance){
            myRestance = "Yes";
        }else{myRestance = "No";}
        return ("Status: " + myStatus +
                "\nActivity form: " + activityType +
                "\nTeam: " + teamType +
                "\nFirstname: " + fName +
                "\nLastname: " + lName +
                "\nAge: " + age +
                "\nE-mail: " + email +
                "\nAddress: " + address +
                "\nRestance? " + myRestance);
    }
}
