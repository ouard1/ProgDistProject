package com.example.sentimentservice.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The Sentiment service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: sentiment.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SentimentServiceGrpc {

  private SentimentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "sentiment.SentimentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.sentimentservice.grpc.SentimentRequest,
      com.example.sentimentservice.grpc.SentimentResponse> getAnalyzeSentimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeSentiment",
      requestType = com.example.sentimentservice.grpc.SentimentRequest.class,
      responseType = com.example.sentimentservice.grpc.SentimentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.sentimentservice.grpc.SentimentRequest,
      com.example.sentimentservice.grpc.SentimentResponse> getAnalyzeSentimentMethod() {
    io.grpc.MethodDescriptor<com.example.sentimentservice.grpc.SentimentRequest, com.example.sentimentservice.grpc.SentimentResponse> getAnalyzeSentimentMethod;
    if ((getAnalyzeSentimentMethod = SentimentServiceGrpc.getAnalyzeSentimentMethod) == null) {
      synchronized (SentimentServiceGrpc.class) {
        if ((getAnalyzeSentimentMethod = SentimentServiceGrpc.getAnalyzeSentimentMethod) == null) {
          SentimentServiceGrpc.getAnalyzeSentimentMethod = getAnalyzeSentimentMethod =
              io.grpc.MethodDescriptor.<com.example.sentimentservice.grpc.SentimentRequest, com.example.sentimentservice.grpc.SentimentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeSentiment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.sentimentservice.grpc.SentimentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.sentimentservice.grpc.SentimentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SentimentServiceMethodDescriptorSupplier("AnalyzeSentiment"))
              .build();
        }
      }
    }
    return getAnalyzeSentimentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SentimentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SentimentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SentimentServiceStub>() {
        @java.lang.Override
        public SentimentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SentimentServiceStub(channel, callOptions);
        }
      };
    return SentimentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SentimentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SentimentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SentimentServiceBlockingStub>() {
        @java.lang.Override
        public SentimentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SentimentServiceBlockingStub(channel, callOptions);
        }
      };
    return SentimentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SentimentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SentimentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SentimentServiceFutureStub>() {
        @java.lang.Override
        public SentimentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SentimentServiceFutureStub(channel, callOptions);
        }
      };
    return SentimentServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The Sentiment service definition.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Analyze sentiment of a given text.
     * </pre>
     */
    default void analyzeSentiment(com.example.sentimentservice.grpc.SentimentRequest request,
        io.grpc.stub.StreamObserver<com.example.sentimentservice.grpc.SentimentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAnalyzeSentimentMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SentimentService.
   * <pre>
   * The Sentiment service definition.
   * </pre>
   */
  public static abstract class SentimentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SentimentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SentimentService.
   * <pre>
   * The Sentiment service definition.
   * </pre>
   */
  public static final class SentimentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SentimentServiceStub> {
    private SentimentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentimentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SentimentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Analyze sentiment of a given text.
     * </pre>
     */
    public void analyzeSentiment(com.example.sentimentservice.grpc.SentimentRequest request,
        io.grpc.stub.StreamObserver<com.example.sentimentservice.grpc.SentimentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeSentimentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SentimentService.
   * <pre>
   * The Sentiment service definition.
   * </pre>
   */
  public static final class SentimentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SentimentServiceBlockingStub> {
    private SentimentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentimentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SentimentServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Analyze sentiment of a given text.
     * </pre>
     */
    public com.example.sentimentservice.grpc.SentimentResponse analyzeSentiment(com.example.sentimentservice.grpc.SentimentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeSentimentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SentimentService.
   * <pre>
   * The Sentiment service definition.
   * </pre>
   */
  public static final class SentimentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SentimentServiceFutureStub> {
    private SentimentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentimentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SentimentServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Analyze sentiment of a given text.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.sentimentservice.grpc.SentimentResponse> analyzeSentiment(
        com.example.sentimentservice.grpc.SentimentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeSentimentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANALYZE_SENTIMENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ANALYZE_SENTIMENT:
          serviceImpl.analyzeSentiment((com.example.sentimentservice.grpc.SentimentRequest) request,
              (io.grpc.stub.StreamObserver<com.example.sentimentservice.grpc.SentimentResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAnalyzeSentimentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.sentimentservice.grpc.SentimentRequest,
              com.example.sentimentservice.grpc.SentimentResponse>(
                service, METHODID_ANALYZE_SENTIMENT)))
        .build();
  }

  private static abstract class SentimentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SentimentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.sentimentservice.grpc.SentimentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SentimentService");
    }
  }

  private static final class SentimentServiceFileDescriptorSupplier
      extends SentimentServiceBaseDescriptorSupplier {
    SentimentServiceFileDescriptorSupplier() {}
  }

  private static final class SentimentServiceMethodDescriptorSupplier
      extends SentimentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SentimentServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SentimentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SentimentServiceFileDescriptorSupplier())
              .addMethod(getAnalyzeSentimentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
