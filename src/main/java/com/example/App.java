package com.example;


import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.exception.NotLoginException;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Example: User login (simulating a login with user ID 1001)
        long userId = 1001;
        StpUtil.createLoginSession(userId);
        System.out.println("User logged in with ID: " + userId);

        // Generate the token
        String token = StpUtil.getTokenValueByLoginId(userId);
        System.out.println("Generated Token: " + token);

        // Verify the token
        try {
            boolean isLogin = StpUtil.isLogin(userId);
            if (isLogin) {
                System.out.println("User is logged in with token: " + token);
            }
        } catch (NotLoginException e) {
            System.out.println("Not logged in!");
        }

        // Logout the user
        StpUtil.logout(userId);
        System.out.println("User logged out");
    }
}
