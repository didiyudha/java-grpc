package com.proto.calculator;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: calculator/calculator.proto")
public final class CalculatorServiceGrpc {

  private CalculatorServiceGrpc() {}

  public static final String SERVICE_NAME = "calculator.CalculatorService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.proto.calculator.CalculatorRequest,
      com.proto.calculator.CalculatorResponse> METHOD_ADD = getAddMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.proto.calculator.CalculatorRequest,
      com.proto.calculator.CalculatorResponse> getAddMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.proto.calculator.CalculatorRequest,
      com.proto.calculator.CalculatorResponse> getAddMethod() {
    return getAddMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.proto.calculator.CalculatorRequest,
      com.proto.calculator.CalculatorResponse> getAddMethodHelper() {
    io.grpc.MethodDescriptor<com.proto.calculator.CalculatorRequest, com.proto.calculator.CalculatorResponse> getAddMethod;
    if ((getAddMethod = CalculatorServiceGrpc.getAddMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getAddMethod = CalculatorServiceGrpc.getAddMethod) == null) {
          CalculatorServiceGrpc.getAddMethod = getAddMethod = 
              io.grpc.MethodDescriptor.<com.proto.calculator.CalculatorRequest, com.proto.calculator.CalculatorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "calculator.CalculatorService", "Add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.CalculatorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.CalculatorResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("Add"))
                  .build();
          }
        }
     }
     return getAddMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPrimeNumberDecompositionMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.proto.calculator.PrimeNumberDecompositionRequest,
      com.proto.calculator.PrimeNumberDecompositionResponse> METHOD_PRIME_NUMBER_DECOMPOSITION = getPrimeNumberDecompositionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.proto.calculator.PrimeNumberDecompositionRequest,
      com.proto.calculator.PrimeNumberDecompositionResponse> getPrimeNumberDecompositionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.proto.calculator.PrimeNumberDecompositionRequest,
      com.proto.calculator.PrimeNumberDecompositionResponse> getPrimeNumberDecompositionMethod() {
    return getPrimeNumberDecompositionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.proto.calculator.PrimeNumberDecompositionRequest,
      com.proto.calculator.PrimeNumberDecompositionResponse> getPrimeNumberDecompositionMethodHelper() {
    io.grpc.MethodDescriptor<com.proto.calculator.PrimeNumberDecompositionRequest, com.proto.calculator.PrimeNumberDecompositionResponse> getPrimeNumberDecompositionMethod;
    if ((getPrimeNumberDecompositionMethod = CalculatorServiceGrpc.getPrimeNumberDecompositionMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getPrimeNumberDecompositionMethod = CalculatorServiceGrpc.getPrimeNumberDecompositionMethod) == null) {
          CalculatorServiceGrpc.getPrimeNumberDecompositionMethod = getPrimeNumberDecompositionMethod = 
              io.grpc.MethodDescriptor.<com.proto.calculator.PrimeNumberDecompositionRequest, com.proto.calculator.PrimeNumberDecompositionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "calculator.CalculatorService", "PrimeNumberDecomposition"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.PrimeNumberDecompositionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.PrimeNumberDecompositionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("PrimeNumberDecomposition"))
                  .build();
          }
        }
     }
     return getPrimeNumberDecompositionMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAverageMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.proto.calculator.AverageRequest,
      com.proto.calculator.AverageResultResponse> METHOD_AVERAGE = getAverageMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.proto.calculator.AverageRequest,
      com.proto.calculator.AverageResultResponse> getAverageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.proto.calculator.AverageRequest,
      com.proto.calculator.AverageResultResponse> getAverageMethod() {
    return getAverageMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.proto.calculator.AverageRequest,
      com.proto.calculator.AverageResultResponse> getAverageMethodHelper() {
    io.grpc.MethodDescriptor<com.proto.calculator.AverageRequest, com.proto.calculator.AverageResultResponse> getAverageMethod;
    if ((getAverageMethod = CalculatorServiceGrpc.getAverageMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getAverageMethod = CalculatorServiceGrpc.getAverageMethod) == null) {
          CalculatorServiceGrpc.getAverageMethod = getAverageMethod = 
              io.grpc.MethodDescriptor.<com.proto.calculator.AverageRequest, com.proto.calculator.AverageResultResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "calculator.CalculatorService", "Average"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.AverageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.AverageResultResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("Average"))
                  .build();
          }
        }
     }
     return getAverageMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getFindMaxMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.proto.calculator.FindMaxRequest,
      com.proto.calculator.FindMaxResponse> METHOD_FIND_MAX = getFindMaxMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.proto.calculator.FindMaxRequest,
      com.proto.calculator.FindMaxResponse> getFindMaxMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.proto.calculator.FindMaxRequest,
      com.proto.calculator.FindMaxResponse> getFindMaxMethod() {
    return getFindMaxMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.proto.calculator.FindMaxRequest,
      com.proto.calculator.FindMaxResponse> getFindMaxMethodHelper() {
    io.grpc.MethodDescriptor<com.proto.calculator.FindMaxRequest, com.proto.calculator.FindMaxResponse> getFindMaxMethod;
    if ((getFindMaxMethod = CalculatorServiceGrpc.getFindMaxMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getFindMaxMethod = CalculatorServiceGrpc.getFindMaxMethod) == null) {
          CalculatorServiceGrpc.getFindMaxMethod = getFindMaxMethod = 
              io.grpc.MethodDescriptor.<com.proto.calculator.FindMaxRequest, com.proto.calculator.FindMaxResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "calculator.CalculatorService", "FindMax"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.FindMaxRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.FindMaxResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("FindMax"))
                  .build();
          }
        }
     }
     return getFindMaxMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSquareRootMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.proto.calculator.SquareRootRequest,
      com.proto.calculator.SquareRootResponse> METHOD_SQUARE_ROOT = getSquareRootMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.proto.calculator.SquareRootRequest,
      com.proto.calculator.SquareRootResponse> getSquareRootMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.proto.calculator.SquareRootRequest,
      com.proto.calculator.SquareRootResponse> getSquareRootMethod() {
    return getSquareRootMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.proto.calculator.SquareRootRequest,
      com.proto.calculator.SquareRootResponse> getSquareRootMethodHelper() {
    io.grpc.MethodDescriptor<com.proto.calculator.SquareRootRequest, com.proto.calculator.SquareRootResponse> getSquareRootMethod;
    if ((getSquareRootMethod = CalculatorServiceGrpc.getSquareRootMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getSquareRootMethod = CalculatorServiceGrpc.getSquareRootMethod) == null) {
          CalculatorServiceGrpc.getSquareRootMethod = getSquareRootMethod = 
              io.grpc.MethodDescriptor.<com.proto.calculator.SquareRootRequest, com.proto.calculator.SquareRootResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "calculator.CalculatorService", "SquareRoot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.SquareRootRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.SquareRootResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("SquareRoot"))
                  .build();
          }
        }
     }
     return getSquareRootMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculatorServiceStub newStub(io.grpc.Channel channel) {
    return new CalculatorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculatorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CalculatorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculatorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CalculatorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CalculatorServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void add(com.proto.calculator.CalculatorRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.CalculatorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Server streaming
     * </pre>
     */
    public void primeNumberDecomposition(com.proto.calculator.PrimeNumberDecompositionRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.PrimeNumberDecompositionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPrimeNumberDecompositionMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.calculator.AverageRequest> average(
        io.grpc.stub.StreamObserver<com.proto.calculator.AverageResultResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAverageMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Bidirictional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.calculator.FindMaxRequest> findMax(
        io.grpc.stub.StreamObserver<com.proto.calculator.FindMaxResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getFindMaxMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Error handling
     * This rpc will throw an exception if the sent number is negative
     * </pre>
     */
    public void squareRoot(com.proto.calculator.SquareRootRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.SquareRootResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSquareRootMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.calculator.CalculatorRequest,
                com.proto.calculator.CalculatorResponse>(
                  this, METHODID_ADD)))
          .addMethod(
            getPrimeNumberDecompositionMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.proto.calculator.PrimeNumberDecompositionRequest,
                com.proto.calculator.PrimeNumberDecompositionResponse>(
                  this, METHODID_PRIME_NUMBER_DECOMPOSITION)))
          .addMethod(
            getAverageMethodHelper(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.proto.calculator.AverageRequest,
                com.proto.calculator.AverageResultResponse>(
                  this, METHODID_AVERAGE)))
          .addMethod(
            getFindMaxMethodHelper(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.proto.calculator.FindMaxRequest,
                com.proto.calculator.FindMaxResponse>(
                  this, METHODID_FIND_MAX)))
          .addMethod(
            getSquareRootMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.calculator.SquareRootRequest,
                com.proto.calculator.SquareRootResponse>(
                  this, METHODID_SQUARE_ROOT)))
          .build();
    }
  }

  /**
   */
  public static final class CalculatorServiceStub extends io.grpc.stub.AbstractStub<CalculatorServiceStub> {
    private CalculatorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void add(com.proto.calculator.CalculatorRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.CalculatorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server streaming
     * </pre>
     */
    public void primeNumberDecomposition(com.proto.calculator.PrimeNumberDecompositionRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.PrimeNumberDecompositionResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getPrimeNumberDecompositionMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.calculator.AverageRequest> average(
        io.grpc.stub.StreamObserver<com.proto.calculator.AverageResultResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAverageMethodHelper(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Bidirictional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.calculator.FindMaxRequest> findMax(
        io.grpc.stub.StreamObserver<com.proto.calculator.FindMaxResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getFindMaxMethodHelper(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Error handling
     * This rpc will throw an exception if the sent number is negative
     * </pre>
     */
    public void squareRoot(com.proto.calculator.SquareRootRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.SquareRootResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSquareRootMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CalculatorServiceBlockingStub extends io.grpc.stub.AbstractStub<CalculatorServiceBlockingStub> {
    private CalculatorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.proto.calculator.CalculatorResponse add(com.proto.calculator.CalculatorRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server streaming
     * </pre>
     */
    public java.util.Iterator<com.proto.calculator.PrimeNumberDecompositionResponse> primeNumberDecomposition(
        com.proto.calculator.PrimeNumberDecompositionRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getPrimeNumberDecompositionMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Error handling
     * This rpc will throw an exception if the sent number is negative
     * </pre>
     */
    public com.proto.calculator.SquareRootResponse squareRoot(com.proto.calculator.SquareRootRequest request) {
      return blockingUnaryCall(
          getChannel(), getSquareRootMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CalculatorServiceFutureStub extends io.grpc.stub.AbstractStub<CalculatorServiceFutureStub> {
    private CalculatorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.calculator.CalculatorResponse> add(
        com.proto.calculator.CalculatorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Error handling
     * This rpc will throw an exception if the sent number is negative
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.calculator.SquareRootResponse> squareRoot(
        com.proto.calculator.SquareRootRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSquareRootMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;
  private static final int METHODID_PRIME_NUMBER_DECOMPOSITION = 1;
  private static final int METHODID_SQUARE_ROOT = 2;
  private static final int METHODID_AVERAGE = 3;
  private static final int METHODID_FIND_MAX = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalculatorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalculatorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD:
          serviceImpl.add((com.proto.calculator.CalculatorRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.calculator.CalculatorResponse>) responseObserver);
          break;
        case METHODID_PRIME_NUMBER_DECOMPOSITION:
          serviceImpl.primeNumberDecomposition((com.proto.calculator.PrimeNumberDecompositionRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.calculator.PrimeNumberDecompositionResponse>) responseObserver);
          break;
        case METHODID_SQUARE_ROOT:
          serviceImpl.squareRoot((com.proto.calculator.SquareRootRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.calculator.SquareRootResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AVERAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.average(
              (io.grpc.stub.StreamObserver<com.proto.calculator.AverageResultResponse>) responseObserver);
        case METHODID_FIND_MAX:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.findMax(
              (io.grpc.stub.StreamObserver<com.proto.calculator.FindMaxResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CalculatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalculatorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.calculator.Calculator.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CalculatorService");
    }
  }

  private static final class CalculatorServiceFileDescriptorSupplier
      extends CalculatorServiceBaseDescriptorSupplier {
    CalculatorServiceFileDescriptorSupplier() {}
  }

  private static final class CalculatorServiceMethodDescriptorSupplier
      extends CalculatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CalculatorServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CalculatorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculatorServiceFileDescriptorSupplier())
              .addMethod(getAddMethodHelper())
              .addMethod(getPrimeNumberDecompositionMethodHelper())
              .addMethod(getAverageMethodHelper())
              .addMethod(getFindMaxMethodHelper())
              .addMethod(getSquareRootMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
