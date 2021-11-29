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

    @Override
    public String toString() {
        return ("Status: " + status +
                "\nActivity form: " + activityType +
                "\nTeam: " + teamType +
                "\nFirstname: " + fName +
                "\nLastname: " + lName +
                "\nAge: " + age +
                "\nE-mail: " + email +
                "\nAddress: " + address +
                "\nArrears? " + arrears);
    }
}
