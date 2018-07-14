package com.github.didiyudha.grpc.calculator.server;

import com.proto.calculator.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {
    @Override
    public void add(CalculatorRequest request, StreamObserver<CalculatorResponse> responseObserver) {
        Long result = request.getFirstNumber() + request.getSecondNumber();
        CalculatorResponse response = CalculatorResponse
                .newBuilder()
                .setTotal(result)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void primeNumberDecomposition(PrimeNumberDecompositionRequest request,
                                         StreamObserver<PrimeNumberDecompositionResponse> responseObserver) {
        Long n = request.getN();
        Long k = 2L;

        while (n > 1) {
            if (n % k == 0) {

                PrimeNumberDecompositionResponse res = PrimeNumberDecompositionResponse
                        .newBuilder()
                        .setResult(k)
                        .build();
                responseObserver.onNext(res);
                n = n / k;

            } else {
                k++;
            }
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<AverageRequest> average(StreamObserver<AverageResultResponse> responseObserver) {
        StreamObserver<AverageRequest> requestStreamObserver = new StreamObserver<AverageRequest>() {
            Long total = 0L;
            int numberOfData = 0;
            @Override
            public void onNext(AverageRequest value) {
                System.out.println("Receive number: "+ value.getNumber());
                total += value.getNumber();
                numberOfData++;
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
                Status.INVALID_ARGUMENT.withDescription("Invalid request").asException();
            }

            @Override
            public void onCompleted() {
                Double avg = ((double) total / (double) numberOfData);
                responseObserver.onNext(AverageResultResponse
                        .newBuilder()
                        .setResult(avg)
                        .build());
                responseObserver.onCompleted();
            }
        };
        return  requestStreamObserver;
    }

    @Override
    public StreamObserver<FindMaxRequest> findMax(StreamObserver<FindMaxResponse> responseObserver) {
        List<Long> data = new ArrayList<>();

        StreamObserver<FindMaxRequest> requestStreamObserver =
                new StreamObserver<FindMaxRequest>() {
                    Long max = -100000L;
                    @Override
                    public void onNext(FindMaxRequest value) {
                        Long n = value.getN();
                        if (n > max) {
                            max = n;
                        }
                        responseObserver.onNext(FindMaxResponse
                                .newBuilder()
                                .setResult(max)
                                .build());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onCompleted() {
                        responseObserver.onCompleted();
                    }
                };
        return requestStreamObserver;
    }

    @Override
    public void squareRoot(SquareRootRequest request, StreamObserver<SquareRootResponse> responseObserver) {
        Integer number = request.getNumber();

        if (number > 0) {
            Double numberRoot = Math.sqrt(number);
            responseObserver.onNext(SquareRootResponse
                    .newBuilder()
                    .setNumberRoot(numberRoot)
                    .build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(
                    Status
                            .INVALID_ARGUMENT
                            .withDescription("The number being sent is not positive")
                            .augmentDescription("Number sent: "+ number)
                            .asRuntimeException()
            );
        }
    }
}
