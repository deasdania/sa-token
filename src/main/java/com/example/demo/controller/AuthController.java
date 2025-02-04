package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import cn.dev33.satoken.stp.StpUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Use a secure key for production

    // Login endpoint (generating JWT)
    @PostMapping("/login")
    public ResponseDTO login(@RequestParam("loginId") long loginId,
                             @RequestParam("username") String username) {
        try {
            // Create login session with Sa-Token
            StpUtil.createLoginSession(loginId);

            // Generate JWT token
            String token = generateJwtToken(loginId);

            return new ResponseDTO("User logged in with ID: " + loginId, token);
        } catch (Exception e) {
            return new ResponseDTO("Error during login: " + e.getMessage());
        }
    }

    // JWT generation logic
    private String generateJwtToken(long loginId) {
        return Jwts.builder()
                .setSubject(String.valueOf(loginId))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour expiration
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Validate Token endpoint
    @PostMapping("/validate")
    public ResponseDTO validateToken(@RequestParam("token") String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            return new ResponseDTO("Token is valid for login ID: " + claims.getSubject());
        } catch (Exception e) {
            return new ResponseDTO("Invalid or expired token.");
        }
    }
}
