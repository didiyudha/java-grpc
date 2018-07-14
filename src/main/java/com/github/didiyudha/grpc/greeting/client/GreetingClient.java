package com.github.didiyudha.grpc.greeting.client;

import com.proto.greet.*;
import io.grpc.*;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.net.ssl.SSLException;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GreetingClient {

    public void run() throws SSLException {
        ManagedChannel channel =
                ManagedChannelBuilder.forAddress("localhost", 50051)
                        .usePlaintext()
                        .build();

        ManagedChannel securedChannel = NettyChannelBuilder.forAddress("localhost",50051)
                .sslContext(GrpcSslContexts.forClient().trustManager(new File("ssl/ca.crt")).build())
                .build();

        // Create blocking client
//        GreetServiceGrpc.GreetServiceBlockingStub syncClient =
//                GreetServiceGrpc.newBlockingStub(channel);

        GreetServiceGrpc.GreetServiceBlockingStub syncClient =
                GreetServiceGrpc.newBlockingStub(securedChannel);

        doUnaryCall(syncClient);
        // doServerStreamingCall(syncClient);

//        try {
//            doClientStreamingCall(channel);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // doBidirectionalStreamingCall(channel);
        // callWithDeadline(channel);

        System.out.println("Shutting down the channel");
        channel.shutdown();
    }

    private void doUnaryCall(GreetServiceGrpc.GreetServiceBlockingStub client) {
        Greeting greeting = Greeting.newBuilder()
                .setFirstName("Didi")
                .setLastName("Yudha")
                .build();

        // Build request
        GreetRequest request = GreetRequest.newBuilder()
                .setGreeting(greeting)
                .build();

        GreetResponse response = client.greet(request);
        System.out.println("Response: " + response.toString());

    }

    private void doServerStreamingCall(GreetServiceGrpc.GreetServiceBlockingStub client) {
        // Server streaming
        // Request
        GreetManyTimesRequest greetManyTimesRequest =
                GreetManyTimesRequest.newBuilder()
                        .setGreeting(
                                Greeting.newBuilder()
                                        .setFirstName("Didi")
                                        .setLastName("Yudha").build()
                        ).build();

        Iterator<GreetManyTimesResponse> greetManyTimesResponses =
                client.greetManyTimes(greetManyTimesRequest);

        greetManyTimesResponses.forEachRemaining(res -> {
            System.out.println("response: "+res.getResult());
        });
    }

    private void doClientStreamingCall(ManagedChannel channel) throws InterruptedException {
        // Create asynchronous client
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<LongGreetRequest> requestStreamObserver = asyncClient.longGreet(
                new StreamObserver<LongGreetResponse>() {
            @Override
            public void onNext(LongGreetResponse value) {
                // We get a response from the server
                System.out.println("Received a response from the server");
                System.out.println(value.getResult());
                // On next will be called only once
            }

            @Override
            public void onError(Throwable t) {
                // we get an error from server
            }

            @Override
            public void onCompleted() {
                // The server is done sending us data
                // onCompleted will be called right after onNext()
                System.out.println("Server has completed sending us something");
                latch.countDown();
            }
        });

        // Streaming message #1
        System.out.println("Sending message #1");
        requestStreamObserver.onNext(LongGreetRequest
                .newBuilder()
                .setGreeting(Greeting
                        .newBuilder()
                        .setFirstName("Didi")
                        .build())
                .build());

        // Streaming message #2
        System.out.println("Sending message #2");
        requestStreamObserver.onNext(LongGreetRequest
                .newBuilder()
                .setGreeting(Greeting
                        .newBuilder()
                        .setFirstName("Yudha")
                        .build())
                .build());

        // // Streaming message #2
        System.out.println("Sending message #3");
        requestStreamObserver.onNext(LongGreetRequest
                .newBuilder()
                .setGreeting(Greeting
                        .newBuilder()
                        .setFirstName("Perwira")
                        .build())
                .build());

        requestStreamObserver.onCompleted();
        latch.await(3, TimeUnit.SECONDS);
    }

    private void doBidirectionalStreamingCall(ManagedChannel channel) {
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<GreetEveryoneRequest> requestStreamObserver =
                asyncClient.greetEveryone(new StreamObserver<GreetEveryoneResponse>() {
            @Override
            public void onNext(GreetEveryoneResponse value) {
                String result = value.getResult();
                System.out.println("Response from server: "+ result);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Server is done sending data");
                latch.countDown();
            }
        });

        Arrays.asList("Didi", "Yudha", "Perwira").forEach(name -> {
            System.out.println("Sending: "+ name);
            requestStreamObserver.onNext(GreetEveryoneRequest
                    .newBuilder()
                    .setGreeting(Greeting
                            .newBuilder()
                            .setFirstName(name)
                            .build())
                    .build());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        requestStreamObserver.onCompleted();

        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void callWithDeadline(ManagedChannel channel) {
       GreetServiceGrpc.GreetServiceBlockingStub blockingStub = GreetServiceGrpc.newBlockingStub(channel);

       try {

           System.out.println("Sending a request with a deadline of 300 ms");

           GreetWithDeadlineResponse response =
                   blockingStub.withDeadlineAfter(3000, TimeUnit.MILLISECONDS)
                           .greetWithDeadline(GreetWithDeadlineRequest
                                   .newBuilder()
                                   .setGreeting(Greeting
                                           .newBuilder()
                                           .setFirstName("Didi")
                                           .build())
                                   .build());

           System.out.println(response.getResult());

       } catch (StatusRuntimeException e) {
           e.printStackTrace();
       }

        try {

            System.out.println("Sending a request with a deadline of 100 ms");

            GreetWithDeadlineResponse response =
                    blockingStub.withDeadlineAfter(100, TimeUnit.MILLISECONDS)
                            .greetWithDeadline(GreetWithDeadlineRequest
                                    .newBuilder()
                                    .setGreeting(Greeting
                                            .newBuilder()
                                            .setFirstName("Didi")
                                            .build())
                                    .build());

            System.out.println(response.getResult());

        } catch (StatusRuntimeException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SSLException {
        System.out.println("Greeting client gRPC");
        GreetingClient greetingClient = new GreetingClient();
        greetingClient.run();
    }
}
