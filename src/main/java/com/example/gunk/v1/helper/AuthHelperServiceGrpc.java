package com.example.gunk.v1.helper;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.0)",
    comments = "Source: myapp/v1/helper/all.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AuthHelperServiceGrpc {

  private AuthHelperServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "helper.AuthHelperService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.gunk.v1.helper.LoginRequest,
      com.example.gunk.v1.helper.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login",
      requestType = com.example.gunk.v1.helper.LoginRequest.class,
      responseType = com.example.gunk.v1.helper.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gunk.v1.helper.LoginRequest,
      com.example.gunk.v1.helper.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<com.example.gunk.v1.helper.LoginRequest, com.example.gunk.v1.helper.LoginResponse> getLoginMethod;
    if ((getLoginMethod = AuthHelperServiceGrpc.getLoginMethod) == null) {
      synchronized (AuthHelperServiceGrpc.class) {
        if ((getLoginMethod = AuthHelperServiceGrpc.getLoginMethod) == null) {
          AuthHelperServiceGrpc.getLoginMethod = getLoginMethod =
              io.grpc.MethodDescriptor.<com.example.gunk.v1.helper.LoginRequest, com.example.gunk.v1.helper.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gunk.v1.helper.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gunk.v1.helper.LoginResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthHelperServiceMethodDescriptorSupplier("Login"))
              .build();
        }
      }
    }
    return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.gunk.v1.helper.LogoutRequest,
      com.example.gunk.v1.helper.LogoutResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Logout",
      requestType = com.example.gunk.v1.helper.LogoutRequest.class,
      responseType = com.example.gunk.v1.helper.LogoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gunk.v1.helper.LogoutRequest,
      com.example.gunk.v1.helper.LogoutResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<com.example.gunk.v1.helper.LogoutRequest, com.example.gunk.v1.helper.LogoutResponse> getLogoutMethod;
    if ((getLogoutMethod = AuthHelperServiceGrpc.getLogoutMethod) == null) {
      synchronized (AuthHelperServiceGrpc.class) {
        if ((getLogoutMethod = AuthHelperServiceGrpc.getLogoutMethod) == null) {
          AuthHelperServiceGrpc.getLogoutMethod = getLogoutMethod =
              io.grpc.MethodDescriptor.<com.example.gunk.v1.helper.LogoutRequest, com.example.gunk.v1.helper.LogoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gunk.v1.helper.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gunk.v1.helper.LogoutResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthHelperServiceMethodDescriptorSupplier("Logout"))
              .build();
        }
      }
    }
    return getLogoutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.gunk.v1.helper.ValidateTokenRequest,
      com.example.gunk.v1.helper.ValidateTokenResponse> getValidateTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateToken",
      requestType = com.example.gunk.v1.helper.ValidateTokenRequest.class,
      responseType = com.example.gunk.v1.helper.ValidateTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gunk.v1.helper.ValidateTokenRequest,
      com.example.gunk.v1.helper.ValidateTokenResponse> getValidateTokenMethod() {
    io.grpc.MethodDescriptor<com.example.gunk.v1.helper.ValidateTokenRequest, com.example.gunk.v1.helper.ValidateTokenResponse> getValidateTokenMethod;
    if ((getValidateTokenMethod = AuthHelperServiceGrpc.getValidateTokenMethod) == null) {
      synchronized (AuthHelperServiceGrpc.class) {
        if ((getValidateTokenMethod = AuthHelperServiceGrpc.getValidateTokenMethod) == null) {
          AuthHelperServiceGrpc.getValidateTokenMethod = getValidateTokenMethod =
              io.grpc.MethodDescriptor.<com.example.gunk.v1.helper.ValidateTokenRequest, com.example.gunk.v1.helper.ValidateTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gunk.v1.helper.ValidateTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gunk.v1.helper.ValidateTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthHelperServiceMethodDescriptorSupplier("ValidateToken"))
              .build();
        }
      }
    }
    return getValidateTokenMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthHelperServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthHelperServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthHelperServiceStub>() {
        @java.lang.Override
        public AuthHelperServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthHelperServiceStub(channel, callOptions);
        }
      };
    return AuthHelperServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthHelperServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthHelperServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthHelperServiceBlockingStub>() {
        @java.lang.Override
        public AuthHelperServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthHelperServiceBlockingStub(channel, callOptions);
        }
      };
    return AuthHelperServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthHelperServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthHelperServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthHelperServiceFutureStub>() {
        @java.lang.Override
        public AuthHelperServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthHelperServiceFutureStub(channel, callOptions);
        }
      };
    return AuthHelperServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void login(com.example.gunk.v1.helper.LoginRequest request,
        io.grpc.stub.StreamObserver<com.example.gunk.v1.helper.LoginResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    default void logout(com.example.gunk.v1.helper.LogoutRequest request,
        io.grpc.stub.StreamObserver<com.example.gunk.v1.helper.LogoutResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    /**
     */
    default void validateToken(com.example.gunk.v1.helper.ValidateTokenRequest request,
        io.grpc.stub.StreamObserver<com.example.gunk.v1.helper.ValidateTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateTokenMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AuthHelperService.
   */
  public static abstract class AuthHelperServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AuthHelperServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AuthHelperService.
   */
  public static final class AuthHelperServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AuthHelperServiceStub> {
    private AuthHelperServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthHelperServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthHelperServiceStub(channel, callOptions);
    }

    /**
     */
    public void login(com.example.gunk.v1.helper.LoginRequest request,
        io.grpc.stub.StreamObserver<com.example.gunk.v1.helper.LoginResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(com.example.gunk.v1.helper.LogoutRequest request,
        io.grpc.stub.StreamObserver<com.example.gunk.v1.helper.LogoutResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateToken(com.example.gunk.v1.helper.ValidateTokenRequest request,
        io.grpc.stub.StreamObserver<com.example.gunk.v1.helper.ValidateTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateTokenMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AuthHelperService.
   */
  public static final class AuthHelperServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AuthHelperServiceBlockingStub> {
    private AuthHelperServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthHelperServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthHelperServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.gunk.v1.helper.LoginResponse login(com.example.gunk.v1.helper.LoginRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gunk.v1.helper.LogoutResponse logout(com.example.gunk.v1.helper.LogoutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gunk.v1.helper.ValidateTokenResponse validateToken(com.example.gunk.v1.helper.ValidateTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateTokenMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AuthHelperService.
   */
  public static final class AuthHelperServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AuthHelperServiceFutureStub> {
    private AuthHelperServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthHelperServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthHelperServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gunk.v1.helper.LoginResponse> login(
        com.example.gunk.v1.helper.LoginRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gunk.v1.helper.LogoutResponse> logout(
        com.example.gunk.v1.helper.LogoutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gunk.v1.helper.ValidateTokenResponse> validateToken(
        com.example.gunk.v1.helper.ValidateTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateTokenMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_LOGOUT = 1;
  private static final int METHODID_VALIDATE_TOKEN = 2;

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
        case METHODID_LOGIN:
          serviceImpl.login((com.example.gunk.v1.helper.LoginRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gunk.v1.helper.LoginResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((com.example.gunk.v1.helper.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gunk.v1.helper.LogoutResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_TOKEN:
          serviceImpl.validateToken((com.example.gunk.v1.helper.ValidateTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gunk.v1.helper.ValidateTokenResponse>) responseObserver);
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
          getLoginMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.gunk.v1.helper.LoginRequest,
              com.example.gunk.v1.helper.LoginResponse>(
                service, METHODID_LOGIN)))
        .addMethod(
          getLogoutMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.gunk.v1.helper.LogoutRequest,
              com.example.gunk.v1.helper.LogoutResponse>(
                service, METHODID_LOGOUT)))
        .addMethod(
          getValidateTokenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.gunk.v1.helper.ValidateTokenRequest,
              com.example.gunk.v1.helper.ValidateTokenResponse>(
                service, METHODID_VALIDATE_TOKEN)))
        .build();
  }

  private static abstract class AuthHelperServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthHelperServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.gunk.v1.helper.All.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthHelperService");
    }
  }

  private static final class AuthHelperServiceFileDescriptorSupplier
      extends AuthHelperServiceBaseDescriptorSupplier {
    AuthHelperServiceFileDescriptorSupplier() {}
  }

  private static final class AuthHelperServiceMethodDescriptorSupplier
      extends AuthHelperServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AuthHelperServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AuthHelperServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthHelperServiceFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getLogoutMethod())
              .addMethod(getValidateTokenMethod())
              .build();
        }
      }
    }
    return result;
  }
}
