package com.example.demo.dto;

public class ResponseDTO {

    private String message;
    private String token;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
