package com.hamdaankhalid.grpc;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Raft.proto")
public final class RaftServiceGrpc {

  private RaftServiceGrpc() {}

  public static final String SERVICE_NAME = "RaftService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.hamdaankhalid.grpc.VoteRequest,
      com.hamdaankhalid.grpc.VoteResponse> getRequestVotesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "requestVotes",
      requestType = com.hamdaankhalid.grpc.VoteRequest.class,
      responseType = com.hamdaankhalid.grpc.VoteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.hamdaankhalid.grpc.VoteRequest,
      com.hamdaankhalid.grpc.VoteResponse> getRequestVotesMethod() {
    io.grpc.MethodDescriptor<com.hamdaankhalid.grpc.VoteRequest, com.hamdaankhalid.grpc.VoteResponse> getRequestVotesMethod;
    if ((getRequestVotesMethod = RaftServiceGrpc.getRequestVotesMethod) == null) {
      synchronized (RaftServiceGrpc.class) {
        if ((getRequestVotesMethod = RaftServiceGrpc.getRequestVotesMethod) == null) {
          RaftServiceGrpc.getRequestVotesMethod = getRequestVotesMethod = 
              io.grpc.MethodDescriptor.<com.hamdaankhalid.grpc.VoteRequest, com.hamdaankhalid.grpc.VoteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RaftService", "requestVotes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hamdaankhalid.grpc.VoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hamdaankhalid.grpc.VoteResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RaftServiceMethodDescriptorSupplier("requestVotes"))
                  .build();
          }
        }
     }
     return getRequestVotesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.hamdaankhalid.grpc.Heartbeat,
      com.hamdaankhalid.grpc.Heartbeat> getLeaderSentMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "leaderSentMessage",
      requestType = com.hamdaankhalid.grpc.Heartbeat.class,
      responseType = com.hamdaankhalid.grpc.Heartbeat.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.hamdaankhalid.grpc.Heartbeat,
      com.hamdaankhalid.grpc.Heartbeat> getLeaderSentMessageMethod() {
    io.grpc.MethodDescriptor<com.hamdaankhalid.grpc.Heartbeat, com.hamdaankhalid.grpc.Heartbeat> getLeaderSentMessageMethod;
    if ((getLeaderSentMessageMethod = RaftServiceGrpc.getLeaderSentMessageMethod) == null) {
      synchronized (RaftServiceGrpc.class) {
        if ((getLeaderSentMessageMethod = RaftServiceGrpc.getLeaderSentMessageMethod) == null) {
          RaftServiceGrpc.getLeaderSentMessageMethod = getLeaderSentMessageMethod = 
              io.grpc.MethodDescriptor.<com.hamdaankhalid.grpc.Heartbeat, com.hamdaankhalid.grpc.Heartbeat>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RaftService", "leaderSentMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hamdaankhalid.grpc.Heartbeat.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hamdaankhalid.grpc.Heartbeat.getDefaultInstance()))
                  .setSchemaDescriptor(new RaftServiceMethodDescriptorSupplier("leaderSentMessage"))
                  .build();
          }
        }
     }
     return getLeaderSentMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RaftServiceStub newStub(io.grpc.Channel channel) {
    return new RaftServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RaftServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RaftServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RaftServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RaftServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RaftServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void requestVotes(com.hamdaankhalid.grpc.VoteRequest request,
        io.grpc.stub.StreamObserver<com.hamdaankhalid.grpc.VoteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestVotesMethod(), responseObserver);
    }

    /**
     */
    public void leaderSentMessage(com.hamdaankhalid.grpc.Heartbeat request,
        io.grpc.stub.StreamObserver<com.hamdaankhalid.grpc.Heartbeat> responseObserver) {
      asyncUnimplementedUnaryCall(getLeaderSentMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestVotesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.hamdaankhalid.grpc.VoteRequest,
                com.hamdaankhalid.grpc.VoteResponse>(
                  this, METHODID_REQUEST_VOTES)))
          .addMethod(
            getLeaderSentMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.hamdaankhalid.grpc.Heartbeat,
                com.hamdaankhalid.grpc.Heartbeat>(
                  this, METHODID_LEADER_SENT_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class RaftServiceStub extends io.grpc.stub.AbstractStub<RaftServiceStub> {
    private RaftServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RaftServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RaftServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RaftServiceStub(channel, callOptions);
    }

    /**
     */
    public void requestVotes(com.hamdaankhalid.grpc.VoteRequest request,
        io.grpc.stub.StreamObserver<com.hamdaankhalid.grpc.VoteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRequestVotesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void leaderSentMessage(com.hamdaankhalid.grpc.Heartbeat request,
        io.grpc.stub.StreamObserver<com.hamdaankhalid.grpc.Heartbeat> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLeaderSentMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RaftServiceBlockingStub extends io.grpc.stub.AbstractStub<RaftServiceBlockingStub> {
    private RaftServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RaftServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RaftServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RaftServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.hamdaankhalid.grpc.VoteResponse requestVotes(com.hamdaankhalid.grpc.VoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getRequestVotesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.hamdaankhalid.grpc.Heartbeat leaderSentMessage(com.hamdaankhalid.grpc.Heartbeat request) {
      return blockingUnaryCall(
          getChannel(), getLeaderSentMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RaftServiceFutureStub extends io.grpc.stub.AbstractStub<RaftServiceFutureStub> {
    private RaftServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RaftServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RaftServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RaftServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.hamdaankhalid.grpc.VoteResponse> requestVotes(
        com.hamdaankhalid.grpc.VoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRequestVotesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.hamdaankhalid.grpc.Heartbeat> leaderSentMessage(
        com.hamdaankhalid.grpc.Heartbeat request) {
      return futureUnaryCall(
          getChannel().newCall(getLeaderSentMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_VOTES = 0;
  private static final int METHODID_LEADER_SENT_MESSAGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RaftServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RaftServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_VOTES:
          serviceImpl.requestVotes((com.hamdaankhalid.grpc.VoteRequest) request,
              (io.grpc.stub.StreamObserver<com.hamdaankhalid.grpc.VoteResponse>) responseObserver);
          break;
        case METHODID_LEADER_SENT_MESSAGE:
          serviceImpl.leaderSentMessage((com.hamdaankhalid.grpc.Heartbeat) request,
              (io.grpc.stub.StreamObserver<com.hamdaankhalid.grpc.Heartbeat>) responseObserver);
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

  private static abstract class RaftServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RaftServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.hamdaankhalid.grpc.Raft.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RaftService");
    }
  }

  private static final class RaftServiceFileDescriptorSupplier
      extends RaftServiceBaseDescriptorSupplier {
    RaftServiceFileDescriptorSupplier() {}
  }

  private static final class RaftServiceMethodDescriptorSupplier
      extends RaftServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RaftServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RaftServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RaftServiceFileDescriptorSupplier())
              .addMethod(getRequestVotesMethod())
              .addMethod(getLeaderSentMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
