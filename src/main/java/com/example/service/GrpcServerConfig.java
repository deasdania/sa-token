package com.example.service;

// import com.example.demo.AuthHelperServiceImpl;
// import io.grpc.Server;
// import io.grpc.ServerBuilder;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class GrpcServerConfig {

//     private final AuthHelperServiceImpl authHelperService;

//     @Autowired
//     public GrpcServerConfig(AuthHelperServiceImpl authHelperService) {
//         this.authHelperService = authHelperService;
//     }

//     @Bean
//     public Server grpcServer() {
//         // Use the service implementation, not the service descriptor
//         return ServerBuilder.forPort(9090)
//                 .addService(authHelperService)  // Add the service implementation here
//                 .build();
//     }
// }
