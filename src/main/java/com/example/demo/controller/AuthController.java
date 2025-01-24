package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.exception.NotLoginException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // Login endpoint
    @PostMapping("/login")
    public ResponseDTO login(@RequestParam("loginId") long loginId,
                             @RequestParam("username") String username) {
        // Simulating login
        try {
            StpUtil.createLoginSession(loginId);
            String token = StpUtil.getTokenValueByLoginId(loginId);
            return new ResponseDTO("User logged in with ID: " + loginId, token);
        } catch (Exception e) {
            return new ResponseDTO("Error during login: " + e.getMessage());
        }
    }

    // Logout endpoint
    @PostMapping("/logout")
    public ResponseDTO logout(@RequestParam("loginId") long loginId) {
        try {
            StpUtil.logout(loginId);
            return new ResponseDTO("Logout successful for login ID: " + loginId);
        } catch (Exception e) {
            return new ResponseDTO("Error during logout: " + e.getMessage());
        }
    }

    // Validate Token endpoint
    @PostMapping("/validate")
    public ResponseDTO validateToken(@RequestParam("token") String token) {
        try {
            Object loginOb = StpUtil.getLoginIdByToken(token);
            if (loginOb == null) {
                return new ResponseDTO("Token is invalid.");
            } else {
                return new ResponseDTO("Token is valid.");
            }
        } catch (NotLoginException e) {
            return new ResponseDTO("Invalid or expired token.");
        } catch (Exception e) {
            return new ResponseDTO("Error during token validation: " + e.getMessage());
        }
    }
}
