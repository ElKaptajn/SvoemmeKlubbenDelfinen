package com.company;

public class Member {
    boolean status;
    String activityType;
    String teamType;
    String fName;
    String lName;
    int age;
    boolean gender;
    String email;
    String address;
    boolean arrears;

    public Member(boolean status, String activityType, String teamType, String fName, String lName,
                  int age, Boolean gender, String email, String address, boolean arrears) {
        this.status = status;
        this.activityType = activityType;
        this.teamType = teamType;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.arrears = arrears;
    }

    public Member() {
    }

    @Override
    public String toString() {
        String myStatus;
        String myGender;
        String myArrears;
        if (status) {
            myStatus = "Active";
        } else {myStatus = "Passive";}
        if (gender) {
            myGender = "Male";
        } else {myGender = "Female";}
        if (arrears) {
            myArrears = "Yes";
        } else {myArrears = "No";}
        return ("Status: " + myStatus +
                "\nActivity form: " + activityType +
                "\nTeam: " + teamType +
                "\nFirstname: " + fName +
                "\nLastname: " + lName +
                "\nAge: " + age +
                "\nGender: " + myGender +
                "\nE-mail: " + email +
                "\nAddress: " + address +
                "\nArrears: " + myArrears);
    }
}
