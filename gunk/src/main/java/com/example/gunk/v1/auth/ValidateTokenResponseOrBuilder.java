// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: all.proto

package com.example.gunk.v1.auth;

public interface ValidateTokenResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:auth.ValidateTokenResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
   */
  boolean hasStatusResponse();
  /**
   * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
   */
  com.example.gunk.v1.auth.StatusResponse getStatusResponse();
  /**
   * <code>.auth.StatusResponse StatusResponse = 1[json_name = "status_response", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
   */
  com.example.gunk.v1.auth.StatusResponseOrBuilder getStatusResponseOrBuilder();

  /**
   * <code>.auth.LoginRequest Data = 2[json_name = "data", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
   */
  boolean hasData();
  /**
   * <code>.auth.LoginRequest Data = 2[json_name = "data", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
   */
  com.example.gunk.v1.auth.LoginRequest getData();
  /**
   * <code>.auth.LoginRequest Data = 2[json_name = "data", ctype = STRING, deprecated = false, lazy = false, jstype = JS_NORMAL, weak = false];</code>
   */
  com.example.gunk.v1.auth.LoginRequestOrBuilder getDataOrBuilder();
}
