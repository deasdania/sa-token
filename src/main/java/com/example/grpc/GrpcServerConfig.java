package com.example.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcServerConfig {

    // @Bean
    // public Server grpcServer(GreeterService greeterService) {
    //     return ServerBuilder.forPort(9090)
    //             .addService(greeterService)
    //             .build();
    // }
}
