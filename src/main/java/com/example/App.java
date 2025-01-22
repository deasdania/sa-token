package com.example;


import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.exception.NotLoginException;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- SA-Token CLI -----");
            System.out.println("1. Login");
            System.out.println("2. Logout");
            System.out.println("3. Validate Token");
            System.out.println("4. Exit");
            System.out.print("Enter option: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine()); // Catch invalid input for choice
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    login(scanner);  // User login and token generation
                    break;
                case 2:
                    logout(scanner); // Logout using the token or login id
                    break;
                case 3:
                    validateToken(scanner); // Validate token
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Simulate Login
    private static void login(Scanner scanner) {
        System.out.print("Enter Login ID (e.g., Login ID): ");
        String loginIDString = scanner.nextLine(); 
        // Convert loginIDString to long
        long loginId = 0;
        try {
            loginId = Long.parseLong(loginIDString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid User ID. Please enter a valid number.");
            return;
        }

        System.out.print("Enter username:");
        String userName = scanner.nextLine();
        if (userName.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return;
        }

        // Create a UserSession object using the parsed data
        //  put the loginId as userId 
        UserSession userSession = new UserSession(loginId, userName);

        System.out.println("User Session created: " + userSession);

        // Simulate login
        try {
            StpUtil.createLoginSession(userSession.getLoginId());
            System.out.println("User logged in with ID: " + userSession.getLoginId());

            // Generate the token
            String token = StpUtil.getTokenValueByLoginId(userSession.getLoginId());
            System.out.println("Generated Token: " + token);
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
        }
    }
    
    // Simulate Logout
    private static void logout(Scanner scanner) {
        System.out.print("Enter Login ID to log out: ");
        String loginId = scanner.nextLine();
        
        if (loginId.isEmpty()) {
            System.out.println("Login ID cannot be empty.");
            return;
        }
        
        try {
            // Invalidate the session for the provided Login ID
            StpUtil.logout(loginId);  // Logout specific session tied to the Login ID
            System.out.println("Logout successful for login ID: " + loginId);
        } catch (Exception e) {
            System.out.println("Error during logout: " + e.getMessage());
        }
    }

    // Validate Token
    private static void validateToken(Scanner scanner) {
        System.out.print("Enter Token to Validate: ");
        String token = scanner.nextLine();

        if (token.isEmpty()) {
            System.out.println("Token cannot be empty.");
            return;
        }
        
        try {
            // Get the remaining validity time of the specified token (unit: seconds, return -1 means permanent validity, -2 means no such value)
            // Use StpUtil to check if the token is valid
            Object loginOb = StpUtil.getLoginIdByToken(token);
            if (loginOb == null) {
                System.out.println("Token is invalid.");
            } else {
                System.out.println("Token is valid.");
            }
        } catch (NotLoginException e) {
            System.out.println("Invalid or expired token.");
        } catch (Exception e) {
            System.out.println("Error during token validation: " + e.getMessage());
        }
    }
}
