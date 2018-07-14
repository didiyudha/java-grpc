package com.github.didiyudha.grpc.calculator.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class CalculatorServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Calculator server gRPC");
        Server server = ServerBuilder.forPort(50055)
                .addService(new CalculatorServiceImpl())
                .build();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received shutdown request");
            server.shutdown();
            System.out.println("Successfully stoped the server");
        }));
        server.awaitTermination();
    }
}
