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
    boolean arrears;
    //arrearsType {junior, senior, pensioner, passiv}

    public Member(String activityType, String teamType, boolean status, String fName, String lName,
                  int age, String email, String address, boolean arrears) {
        this.activityType = activityType;
        this.teamType = teamType;
        this.status = status;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.email = email;
        this.address = address;
        this.arrears = arrears;
    }

    public Member() {
    }

    @Override
    public String toString() {
        String myStatus;
        String myArrears;
        if (status){
            myStatus = "Active";
        }else{myStatus = "Passiv";}
        if (arrears){
            myArrears = "Yes";
        }else{myArrears = "No";}
        return ("Status: " + myStatus +
                "\nActivity form: " + activityType +
                "\nTeam: " + teamType +
                "\nFirstname: " + fName +
                "\nLastname: " + lName +
                "\nAge: " + age +
                "\nE-mail: " + email +
                "\nAddress: " + address +
                "\nArrears? " + myArrears);
    }
}
