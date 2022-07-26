package com.hamdaankhalid.communication;


import com.hamdaankhalid.consensus.Consensus;
import com.hamdaankhalid.consensus.Vote;
import com.hamdaankhalid.grpc.Heartbeat;
import com.hamdaankhalid.grpc.RaftServiceGrpc;
import com.hamdaankhalid.grpc.VoteRequest;
import com.hamdaankhalid.grpc.VoteResponse;
import io.grpc.stub.StreamObserver;

public class RaftService extends RaftServiceGrpc.RaftServiceImplBase {
    private Consensus consensus;

    public RaftService(Consensus consensus) {
        this.consensus = consensus;
    }

    @Override
    public void requestVotes(VoteRequest request, StreamObserver<VoteResponse> responseObserver) {
        Vote voteConsent = consensus.onVoteRequest(request);

        VoteResponse.Builder vrb = VoteResponse.newBuilder();
        vrb.setTerm(voteConsent.getTerm());
        vrb.setVoteGranted(voteConsent.isGranted());

        responseObserver.onNext(vrb.build());
        responseObserver.onCompleted();
    }

    @Override
    public void leaderSentMessage(Heartbeat hbReq, StreamObserver<Heartbeat> responseObserver) {
        consensus.onHeartbeatRecieved(hbReq.getLeaderId());
        responseObserver.onNext(Heartbeat.newBuilder().build());
        responseObserver.onCompleted();
    }
}
