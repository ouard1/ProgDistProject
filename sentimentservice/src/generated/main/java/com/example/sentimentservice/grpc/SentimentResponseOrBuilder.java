// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sentiment.proto

package com.example.sentimentservice.grpc;

public interface SentimentResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:sentiment.SentimentResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * "positive", "negative", or "neutral"
   * </pre>
   *
   * <code>string sentiment = 1;</code>
   * @return The sentiment.
   */
  java.lang.String getSentiment();
  /**
   * <pre>
   * "positive", "negative", or "neutral"
   * </pre>
   *
   * <code>string sentiment = 1;</code>
   * @return The bytes for sentiment.
   */
  com.google.protobuf.ByteString
      getSentimentBytes();
}
