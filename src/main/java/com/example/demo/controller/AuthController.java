package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public AuthController(JwtUtil jwtUtil, RedisTemplate<String, String> redisTemplate) {
        this.jwtUtil = jwtUtil;
        this.redisTemplate = redisTemplate;
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseDTO login(@RequestParam("loginId") long loginId,
                             @RequestParam("username") String username) {
        try {
            String token = jwtUtil.createToken(loginId);
            return new ResponseDTO("User logged in with ID: " + loginId, token);
        } catch (Exception e) {
            return new ResponseDTO("Error during login: " + e.getMessage());
        }
    }

    // Logout endpoint
    @PostMapping("/logout")
    public ResponseDTO logout(@RequestParam("loginId") long loginId) {
        try {
            // Remove the token from Redis on logout
            redisTemplate.delete("token:" + loginId);
            return new ResponseDTO("Logout successful for login ID: " + loginId);
        } catch (Exception e) {
            return new ResponseDTO("Error during logout: " + e.getMessage());
        }
    }

    // Validate Token endpoint
    @PostMapping("/validate")
    public ResponseDTO validateToken(@RequestParam("token") String token) {
        try {
            boolean isValid = jwtUtil.validateToken(token);
            if (isValid) {
                return new ResponseDTO("Token is valid.");
            } else {
                return new ResponseDTO("Token is invalid.");
            }
        } catch (Exception e) {
            return new ResponseDTO("Error during token validation: " + e.getMessage());
        }
    }
}
