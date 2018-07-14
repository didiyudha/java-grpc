package com.github.didiyudha.grpc.calculator.client;

import com.proto.calculator.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Client {

    public void run() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50055)
                .usePlaintext()
                .build();
        CalculatorServiceGrpc.CalculatorServiceBlockingStub client =
                CalculatorServiceGrpc.newBlockingStub(channel);


        // doUnaryCall(client);
        // doServerStreamingCall(client);
        // doClientStreamingCall(channel);
        // doBidirectionalStreamingCall(channel);
        doErrorCall(channel);

        channel.shutdown();
    }

    private void doUnaryCall(CalculatorServiceGrpc.CalculatorServiceBlockingStub client) {
        CalculatorRequest request = CalculatorRequest.newBuilder()
                .setFirstNumber(3)
                .setSecondNumber(10)
                .build();

        // Unary
        CalculatorResponse response = client.add(request);
        System.out.println("response : " + response.getTotal());
    }

    private void doServerStreamingCall(CalculatorServiceGrpc.CalculatorServiceBlockingStub client) {
        PrimeNumberDecompositionRequest primeNumberDecompositionRequest =
                PrimeNumberDecompositionRequest.newBuilder()
                        .setN(120)
                        .build();

        // Server streaming
        Iterator<PrimeNumberDecompositionResponse> res =
                client.primeNumberDecomposition(primeNumberDecompositionRequest);
        res.forEachRemaining(response -> {
            System.out.println(response.getResult());
        });
    }

    private void doClientStreamingCall(ManagedChannel channel) throws InterruptedException {
        CalculatorServiceGrpc.CalculatorServiceStub asyncClient = CalculatorServiceGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<AverageRequest> responseStreamObserver = asyncClient.average(new StreamObserver<AverageResultResponse>() {
            @Override
            public void onNext(AverageResultResponse value) {
                // Server send the response
                System.out.println("Average: "+ value.getResult());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                // Server has been completed sending result
                latch.countDown();
            }
        });

        for (int i = 1; i <= 5000; i++) {
            responseStreamObserver.onNext(AverageRequest
                    .newBuilder()
                    .setNumber(i)
                    .build());
        }

        responseStreamObserver.onCompleted();
        latch.await(5, TimeUnit.SECONDS);
    }

    private void doBidirectionalStreamingCall(ManagedChannel channel) {

        CalculatorServiceGrpc.CalculatorServiceStub asyncClient =
                CalculatorServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<FindMaxRequest> requestStream = asyncClient.findMax(new StreamObserver<FindMaxResponse>() {
            @Override
            public void onNext(FindMaxResponse value) {
                System.out.println("Maximum: " + value.getResult());
            }

            @Override
            public void onError(Throwable t) {
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                latch.countDown();
            }
        });

        Arrays.asList(1,5,3,6,2,20).forEach(n -> {
            System.out.println("Sending: "+ n);
            requestStream.onNext(FindMaxRequest
                    .newBuilder()
                    .setN(n)
                    .build());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doErrorCall(ManagedChannel channel) {
        CalculatorServiceGrpc.CalculatorServiceBlockingStub syncClient = CalculatorServiceGrpc.newBlockingStub(channel);
        int number = -1;

        try {
            SquareRootResponse response = syncClient.squareRoot(SquareRootRequest
                    .newBuilder()
                    .setNumber(number)
                    .build());

            double result = response.getNumberRoot();
            System.out.println("Square root result from "+ 10 + ": "+ result);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Client c = new Client();
        try {
            c.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
