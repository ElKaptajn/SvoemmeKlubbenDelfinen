package com.company;

public class Member {
    int ageType;
    String teamType;
    boolean status;
    String fName;
    String lName;
    int age;
    String email;
    String address;
    boolean restance;

    public Member(int ageType, String teamType, boolean status, String fName, String lName,
                  int age, String email, String address, boolean restance) {
        this.ageType = ageType;
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
        return ("Status: " + status +
                "\nFirstname: " + fName +
                "\nLastname: " + lName +
                "\nAge: " + age +
                "\nE-mail: " + email +
                "\nAddress: " + address +
                "\nRestance? " + restance);
    }
}
