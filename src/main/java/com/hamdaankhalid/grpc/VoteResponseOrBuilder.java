// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Raft.proto

package com.hamdaankhalid.grpc;

public interface VoteResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:VoteResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 term = 1;</code>
   * @return The term.
   */
  int getTerm();

  /**
   * <code>bool voteGranted = 2;</code>
   * @return The voteGranted.
   */
  boolean getVoteGranted();
}
