package com.example.demo.dto;

public class ResponseDTO {

    private String message;
    private String token;
    private String username;
    private String loginID;
    private boolean valid;

    // Constructor for responses with message only
    public ResponseDTO(String message) {
        this.message = message;
    }

    // Constructor for responses with message and token
    public ResponseDTO(String message, String token) {
        this.message = message;
        this.token = token;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }


    public Boolean getIsValid() {
        return valid;
    }

    public void setIsValid(Boolean valid) {
        this.valid = valid;
    }
}
