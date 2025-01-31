package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize Spring context to load RedisConfig
        ApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class, SaTokenConfigure.class);

        // If no arguments are passed, exit
        if (args.length == 0) {
            System.out.println("No arguments provided. Exiting...");
            ((ConfigurableApplicationContext) context).close();
            return;
        }

        String command = args[0];  // First argument (command)

        switch (command) {
            case "login":
                if (args.length < 3) {
                    System.out.println("Usage: login <loginId> <username>");
                    break;
                }
                long loginId = Long.parseLong(args[1]);
                String username = args[2];
                login(loginId, username);
                break;

            case "logout":
                if (args.length < 2) {
                    System.out.println("Usage: logout <loginId>");
                    break;
                }
                String logoutId = args[1];
                logout(logoutId);
                break;

            case "validateToken":
                if (args.length < 2) {
                    System.out.println("Usage: validateToken <token>");
                    break;
                }
                String token = args[1];
                validateToken(token);
                break;

            case "getLoginID":
                if (args.length < 2) {
                    System.out.println("Usage: getLoginID <token>");
                    break;
                }
                String tokenForLoginId = args[1];
                loginIDFromToken(tokenForLoginId);
                break;

            default:
                System.out.println("Unknown command. Available commands: login, logout, validateToken, getLoginID");
        }

        // Close Spring context before exiting
        ((ConfigurableApplicationContext) context).close();
    }

    // Simulate Login
    private static void login(long loginId, String username) {
        // Create a UserSession object using the parsed data
        UserSession userSession = new UserSession(loginId, username);

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
    private static void logout(String loginId) {
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

    // Validate Token (You can validate with Redis if you need to)
    private static void validateToken(String token) {
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

    // Get login ID from Token
    private static void loginIDFromToken(String token) {
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
                System.out.println("Login ID:"+ loginOb.toString());
            }
        } catch (NotLoginException e) {
            System.out.println("Invalid or expired token.");
        } catch (Exception e) {
            System.out.println("Error during token validation: " + e.getMessage());
        }
    }
}
