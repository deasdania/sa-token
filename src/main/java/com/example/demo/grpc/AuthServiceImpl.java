package com.example.demo.grpc;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.auth.AuthServiceGrpc.AuthServiceImplBase;
import com.example.auth.LoginRequest;
import com.example.auth.StatusResponse;
import com.example.auth.ValidateTokenRequest;
import com.example.auth.ValidateTokenResponse;
import com.example.demo.JwtUtil;
import com.example.auth.LoginResponse;
import com.example.auth.LogoutRequest;
import com.example.auth.LogoutResponse;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService 
public class AuthServiceImpl extends AuthServiceImplBase {

    private final JwtUtil jwtUtil;

    @Autowired
    public AuthServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        try {
            long logID = Long.parseLong(request.getLoginID());
            String token = jwtUtil.createToken(logID);
            StatusResponse status = StatusResponse.newBuilder()
                    .setMessage("User logged in with ID: " + request.getLoginID())
                    .build();
            LoginResponse response = LoginResponse.newBuilder()
                    .setStatusResponse(status)
                    .setToken(token)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void logout(LogoutRequest request, StreamObserver<LogoutResponse> responseObserver) {
        try {
            // Implement Redis-based logout logic
            // redisTemplate.delete("token:" + request.getLoginId());
            long logID = jwtUtil.getLoginIdFromToken(request.getToken());
            StatusResponse status = StatusResponse.newBuilder()
                    .setMessage("User logged out with ID: " + logID)
                    .build();
            LogoutResponse response = LogoutResponse.newBuilder()
                    .setStatusResponse(status)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void validateToken(ValidateTokenRequest request, StreamObserver<ValidateTokenResponse> responseObserver) {
        try {
            boolean isValid = jwtUtil.validateToken(request.getToken());
            String message = isValid ? "Token is valid." : "Token is invalid.";
            StatusResponse status = StatusResponse.newBuilder()
                    .setMessage(message)
                    .build();
            ValidateTokenResponse response = ValidateTokenResponse.newBuilder()
                    .setStatusResponse(status)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }
}