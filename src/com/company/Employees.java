package com.company;

public class Employees {
    //enum rankType{Rank1, Rank2, Rank3, RankAdmin};
    String rank;
    String username;
    String password;

    public Employees(String rank, String username, String password) {
        this.rank = rank;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString(){
        return (rank + " " + username + " " + password);
    }
}
