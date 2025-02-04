package com.example.demo.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GrpcServer {

    @Value("${grpc.server.port:9090}")
    private int grpcPort;

    private final AuthServiceImpl authService;

    public GrpcServer(AuthServiceImpl authService) {
        this.authService = authService;
    }

    public void start() throws Exception {
        Server server = ServerBuilder.forPort(grpcPort)
                .addService(authService)
                .addService(ProtoReflectionService.newInstance())
                .build();
        server.start();
        System.out.println("gRPC server started on port " + grpcPort);
        server.awaitTermination();
    }
}
