package com.example.library;

public class Account {
    private String userName;
    private String password;
    private String iD;

    public Account(String userName, String password, String iD) {
        this.userName = userName;
        this.password = password;
        this.iD = iD;
    }

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getID() {
        return iD;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setID(String iD) {
        this.iD = iD;
    }
}
