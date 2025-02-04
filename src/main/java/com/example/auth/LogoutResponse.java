// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: all.proto

package com.example.auth;

/**
 * Protobuf type {@code auth.LogoutResponse}
 */
public  final class LogoutResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:auth.LogoutResponse)
    LogoutResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LogoutResponse.newBuilder() to construct.
  private LogoutResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LogoutResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new LogoutResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LogoutResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            com.example.auth.StatusResponse.Builder subBuilder = null;
            if (statusResponse_ != null) {
              subBuilder = statusResponse_.toBuilder();
            }
            statusResponse_ = input.readMessage(com.example.auth.StatusResponse.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(statusResponse_);
              statusResponse_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.auth.All.internal_static_auth_LogoutResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.auth.All.internal_static_auth_LogoutResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.auth.LogoutResponse.class, com.example.auth.LogoutResponse.Builder.class);
  }

  public static final int STATUSRESPONSE_FIELD_NUMBER = 1;
  private com.example.auth.StatusResponse statusResponse_;
  /**
   * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
   */
  public boolean hasStatusResponse() {
    return statusResponse_ != null;
  }
  /**
   * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
   */
  public com.example.auth.StatusResponse getStatusResponse() {
    return statusResponse_ == null ? com.example.auth.StatusResponse.getDefaultInstance() : statusResponse_;
  }
  /**
   * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
   */
  public com.example.auth.StatusResponseOrBuilder getStatusResponseOrBuilder() {
    return getStatusResponse();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (statusResponse_ != null) {
      output.writeMessage(1, getStatusResponse());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (statusResponse_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getStatusResponse());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.auth.LogoutResponse)) {
      return super.equals(obj);
    }
    com.example.auth.LogoutResponse other = (com.example.auth.LogoutResponse) obj;

    if (hasStatusResponse() != other.hasStatusResponse()) return false;
    if (hasStatusResponse()) {
      if (!getStatusResponse()
          .equals(other.getStatusResponse())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasStatusResponse()) {
      hash = (37 * hash) + STATUSRESPONSE_FIELD_NUMBER;
      hash = (53 * hash) + getStatusResponse().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.auth.LogoutResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.auth.LogoutResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.auth.LogoutResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.auth.LogoutResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.auth.LogoutResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.auth.LogoutResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.auth.LogoutResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.auth.LogoutResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.auth.LogoutResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.auth.LogoutResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.auth.LogoutResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.auth.LogoutResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.auth.LogoutResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code auth.LogoutResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:auth.LogoutResponse)
      com.example.auth.LogoutResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.auth.All.internal_static_auth_LogoutResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.auth.All.internal_static_auth_LogoutResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.auth.LogoutResponse.class, com.example.auth.LogoutResponse.Builder.class);
    }

    // Construct using com.example.gunk.v1.auth.LogoutResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (statusResponseBuilder_ == null) {
        statusResponse_ = null;
      } else {
        statusResponse_ = null;
        statusResponseBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.auth.All.internal_static_auth_LogoutResponse_descriptor;
    }

    @java.lang.Override
    public com.example.auth.LogoutResponse getDefaultInstanceForType() {
      return com.example.auth.LogoutResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.auth.LogoutResponse build() {
      com.example.auth.LogoutResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.auth.LogoutResponse buildPartial() {
      com.example.auth.LogoutResponse result = new com.example.auth.LogoutResponse(this);
      if (statusResponseBuilder_ == null) {
        result.statusResponse_ = statusResponse_;
      } else {
        result.statusResponse_ = statusResponseBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.auth.LogoutResponse) {
        return mergeFrom((com.example.auth.LogoutResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.auth.LogoutResponse other) {
      if (other == com.example.auth.LogoutResponse.getDefaultInstance()) return this;
      if (other.hasStatusResponse()) {
        mergeStatusResponse(other.getStatusResponse());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.example.auth.LogoutResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.auth.LogoutResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.example.auth.StatusResponse statusResponse_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.auth.StatusResponse, com.example.auth.StatusResponse.Builder, com.example.auth.StatusResponseOrBuilder> statusResponseBuilder_;
    /**
     * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
     */
    public boolean hasStatusResponse() {
      return statusResponseBuilder_ != null || statusResponse_ != null;
    }
    /**
     * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
     */
    public com.example.auth.StatusResponse getStatusResponse() {
      if (statusResponseBuilder_ == null) {
        return statusResponse_ == null ? com.example.auth.StatusResponse.getDefaultInstance() : statusResponse_;
      } else {
        return statusResponseBuilder_.getMessage();
      }
    }
    /**
     * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
     */
    public Builder setStatusResponse(com.example.auth.StatusResponse value) {
      if (statusResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        statusResponse_ = value;
        onChanged();
      } else {
        statusResponseBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
     */
    public Builder setStatusResponse(
        com.example.auth.StatusResponse.Builder builderForValue) {
      if (statusResponseBuilder_ == null) {
        statusResponse_ = builderForValue.build();
        onChanged();
      } else {
        statusResponseBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
     */
    public Builder mergeStatusResponse(com.example.auth.StatusResponse value) {
      if (statusResponseBuilder_ == null) {
        if (statusResponse_ != null) {
          statusResponse_ =
            com.example.auth.StatusResponse.newBuilder(statusResponse_).mergeFrom(value).buildPartial();
        } else {
          statusResponse_ = value;
        }
        onChanged();
      } else {
        statusResponseBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
     */
    public Builder clearStatusResponse() {
      if (statusResponseBuilder_ == null) {
        statusResponse_ = null;
        onChanged();
      } else {
        statusResponse_ = null;
        statusResponseBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
     */
    public com.example.auth.StatusResponse.Builder getStatusResponseBuilder() {
      
      onChanged();
      return getStatusResponseFieldBuilder().getBuilder();
    }
    /**
     * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
     */
    public com.example.auth.StatusResponseOrBuilder getStatusResponseOrBuilder() {
      if (statusResponseBuilder_ != null) {
        return statusResponseBuilder_.getMessageOrBuilder();
      } else {
        return statusResponse_ == null ?
            com.example.auth.StatusResponse.getDefaultInstance() : statusResponse_;
      }
    }
    /**
     * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.auth.StatusResponse, com.example.auth.StatusResponse.Builder, com.example.auth.StatusResponseOrBuilder> 
        getStatusResponseFieldBuilder() {
      if (statusResponseBuilder_ == null) {
        statusResponseBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.example.auth.StatusResponse, com.example.auth.StatusResponse.Builder, com.example.auth.StatusResponseOrBuilder>(
                getStatusResponse(),
                getParentForChildren(),
                isClean());
        statusResponse_ = null;
      }
      return statusResponseBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:auth.LogoutResponse)
  }

  // @@protoc_insertion_point(class_scope:auth.LogoutResponse)
  private static final com.example.auth.LogoutResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.auth.LogoutResponse();
  }

  public static com.example.auth.LogoutResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LogoutResponse>
      PARSER = new com.google.protobuf.AbstractParser<LogoutResponse>() {
    @java.lang.Override
    public LogoutResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LogoutResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LogoutResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LogoutResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.auth.LogoutResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

