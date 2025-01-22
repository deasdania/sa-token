package com.example;

public class UserSession {
    private long loginId;
    private String userName;

    // Constructor to initialize userId and userName
    public UserSession(long loginId, String userName) {
        this.loginId = loginId;
        this.userName = userName;
    }

    // Getter for loginId
    public long getLoginId() {
        return loginId;
    }

    // Getter for userName
    public String getUserName() {
        return userName;
    }

    // Override toString method to print UserSession details
    @Override
    public String toString() {
        return "UserSession{userId=" + loginId + ", userName='" + userName + "'}";
    }
}
