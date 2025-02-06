package com.example.demo.util;

import com.example.demo.dto.ResponseDTO;
import org.springframework.stereotype.Component;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;

@Component
public class JwtUtil {

    // Generate and store JWT token in Redis
    public ResponseDTO createToken(long loginId) {
        // Create JWT token
        try {
            StpUtil.createLoginSession(loginId);
            String token = StpUtil.getTokenValueByLoginId(loginId);
            return new ResponseDTO("User logged in with ID: " + loginId, token);
        } catch (Exception e) {
            return new ResponseDTO("Error during login: " + e.getMessage());
        }
    }

    // Logout session 
    public ResponseDTO logout(String token) {
        try {
            Object loginID = StpUtil.getLoginIdByToken(token);
            StpUtil.logout(loginID);
            return new ResponseDTO("Logout successful for login ID: " + loginID);
        } catch (Exception e) {
            return new ResponseDTO("Error during logout: " + e.getMessage());
        }
    }

    // Validate token by checking Redis for its existence
    public ResponseDTO validateToken(String token) {
        try {
            Object loginOb = StpUtil.getLoginIdByToken(token);
            if (loginOb == null) {
                return new ResponseDTO("Token is invalid.");
            } else {
                ResponseDTO resDTO = new ResponseDTO("Token is valid.");
                resDTO.setLoginID(loginOb.toString());
                resDTO.setIsValid(true);
                // resDTO.setUsername(StpUtil.);
                return resDTO;
            }
        } catch (NotLoginException e) {
            return new ResponseDTO("Invalid or expired token.");
        } catch (Exception e) {
            return new ResponseDTO("Error during token validation: " + e.getMessage());
        }
    }

}