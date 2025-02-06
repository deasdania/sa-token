package com.example.service;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.util.JwtUtil;
import com.example.gunk.v1.helper.AuthHelperServiceGrpc;
import com.example.gunk.v1.helper.LoginRequest;
import com.example.gunk.v1.helper.LoginResponse;
import com.example.gunk.v1.helper.LogoutRequest;
import com.example.gunk.v1.helper.LogoutResponse;
import com.example.gunk.v1.helper.StatusResponse;
import com.example.gunk.v1.helper.ValidateTokenRequest;
import com.example.gunk.v1.helper.ValidateTokenResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import org.springframework.beans.factory.annotation.Autowired;

@GrpcService // Add the @Service annotation to register this as a Spring Bean
public class AuthHelperServiceImpl extends AuthHelperServiceGrpc.AuthHelperServiceImplBase {

    private final JwtUtil jwtUtil;

    @Autowired
    public AuthHelperServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        try {
            long logID = Long.parseLong(request.getLoginID());
            ResponseDTO res = jwtUtil.createToken(logID);
            StatusResponse status = StatusResponse.newBuilder()
                    .setMessage(res.getMessage())
                    .build();
            LoginResponse response = LoginResponse.newBuilder()
                    .setStatusResponse(status)
                    .setToken(res.getToken())
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
            ResponseDTO res = jwtUtil.logout(request.getToken());
            StatusResponse status = StatusResponse.newBuilder()
                    .setMessage(res.getMessage())
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
            ResponseDTO res = jwtUtil.validateToken(request.getToken());
            StatusResponse status = StatusResponse.newBuilder()
                    .setMessage(res.getMessage())
                    .build();
            LoginRequest data = LoginRequest.newBuilder()
                    .setLoginID(res.getLoginID())
                    .build();
            ValidateTokenResponse response = ValidateTokenResponse.newBuilder()
                    .setStatusResponse(status)
                    .setData(data)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            ResponseDTO res = jwtUtil.validateToken(request.getToken());
            StatusResponse status = StatusResponse.newBuilder()
                    .setMessage(res.getMessage())
                    .build();
            ValidateTokenResponse response = ValidateTokenResponse.newBuilder()
                    .setStatusResponse(status)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}