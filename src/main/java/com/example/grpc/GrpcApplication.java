package com.example.grpc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.grpc")
public class GrpcApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GrpcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("gRPC server is running...");
    }
}
