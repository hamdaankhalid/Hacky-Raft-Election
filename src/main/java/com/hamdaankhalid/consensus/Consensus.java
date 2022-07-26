package com.hamdaankhalid.consensus;

import com.hamdaankhalid.grpc.Heartbeat;
import com.hamdaankhalid.grpc.RaftServiceGrpc;
import com.hamdaankhalid.grpc.VoteRequest;
import com.hamdaankhalid.grpc.VoteResponse;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.hamdaankhalid.consensus.State.FOLLOWER;

public class Consensus {

    private static final int MAX_INTERVAL = 300;
    private static final int MIN_INTERVAL = 150;

    private int currentTerm;
    private String votedFor;
    private State state;

    private String currentLeader;
    private String id;
    private Map<String, RaftServiceGrpc.RaftServiceBlockingStub> neighbors;
    private boolean runningElection;

    private Timer timer;
    private TimerTask leaderNotContactedTimerTask;

    private Lock lock;

    public Consensus(String id, Map<String, RaftServiceGrpc.RaftServiceBlockingStub> neighbors, Timer timer) {
        this.currentTerm = 0;
        this.id = id;
        this.neighbors = neighbors;
        this.runningElection = false;
        this.timer = timer;
        this.state = FOLLOWER;
        this.lock = new ReentrantLock();
    }

    public Vote onVoteRequest(VoteRequest request) {
        System.out.println(id + ": I have been requested for vote by " + request.getCandidateId());

        lock.lock();
        try {
            this.state = FOLLOWER;
            this.votedFor = request.getCandidateId();
        } finally {
            lock.unlock();
        }


        this.leaderNotContactedTimer();

        System.out.println(id + ": I am now a follower, and I give you my vote to " + request.getCandidateId());
        return new Vote(request.getTerm(), true);
    }

    public void onHeartbeatRecieved(String leaderId) {
        lock.lock();
        try {
            this.currentLeader = leaderId;
        } finally {
            lock.unlock();
        }

        System.out.println("Heartbeat received from leader: " + leaderId);

        // restart the leader not contacted timer task
        // System.out.println("Resetting leader not contacted timer");
        try {
            leaderNotContactedTimerTask.cancel();
        } catch(IllegalStateException err) {
            leaderNotContactedTimer();
        }
    }

    public synchronized void leaderNotContactedTimer() {
        long randomInterval = (long) ((Math.random() * (MAX_INTERVAL - MIN_INTERVAL)) + MIN_INTERVAL);
        this.leaderNotContactedTimerTask = new TimerTask() {
            @Override
            public void run() {
                if (state != FOLLOWER) {
                    this.cancel();
                    return;
                }

                // MAKE THIS THREAD SAFE
                currentTerm++;

                System.out.println("Leader has not contacted node within the expected interval!");
                System.out.println("Kicking off election process");
                System.out.println("Cancelling leaderNOtContactedTimerTask ");

                this.cancel();
                startElection();
            }
        };

        timer.schedule(this.leaderNotContactedTimerTask, randomInterval);
    }

    public synchronized void startElection() {
        this.state = State.CANDIDATE;
        int currentTerm = this.currentTerm;
        String myId = this.id;
        final double quorum = Math.floor(neighbors.size()/2);

        Thread electionThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int recievedVotes = 0;

                for (String neighbor: neighbors.keySet()) {
                    RaftServiceGrpc.RaftServiceBlockingStub client = neighbors.get(neighbor);

                    VoteRequest.Builder vrb = VoteRequest.newBuilder();
                    vrb.setCandidateId(myId);
                    vrb.setTerm(currentTerm);

                    System.out.println(myId + " node has sent a request to node " + neighbor);

                    VoteResponse voteResponse = client.requestVotes(vrb.build());

                    System.out.println(neighbor + " node has sent a response for term " + voteResponse.getTerm()
                            + " with voteGranted: " + voteResponse.getVoteGranted());

                    if(voteResponse.getVoteGranted() && voteResponse.getTerm() == currentTerm) {
                        recievedVotes++;
                    }

                    if (
                            recievedVotes >= 1
                        // quorum
                    ) {
                        System.out.println(id + ": I am now a leader and I do not need to keep waiting to hear back" +
                                " a leader.");

                        // MAKE THIS THREAD SAFE
                        state = State.LEADER;

                        // kick off things a leader should be doing
                        runTransientLeadership();
                        return;
                    }
                }

                state = FOLLOWER;
                leaderNotContactedTimer();
            }
        });

        electionThread.start();
    }

    public void runTransientLeadership() {
        // We play the role of a leader only for certain amount before going through a "simulated transient failure"
        new Thread(new Runnable() {
            @Override
            public void run() {
                long randomDurationOfLeaderShip = (long) ((Math.random() * (100 - 50)) + 50);

                System.out.println("Random duration of leader ship has been chosen to be " + randomDurationOfLeaderShip + " units.");

                // MAKE THIS THREAD SAFE
                State currentState = state;
                String myId = id;

                while (randomDurationOfLeaderShip > 0 && currentState == State.LEADER) {
                    for (String neighbor: neighbors.keySet()) {

                        // send a heartbeat to each neighbor
                        RaftServiceGrpc.RaftServiceBlockingStub client = neighbors.get(neighbor);
                        client.leaderSentMessage(Heartbeat.newBuilder().setLeaderId(myId).build());

                    }
                    randomDurationOfLeaderShip--;
                }

                // Simulate the node coming back alive!
                state = FOLLOWER;
                leaderNotContactedTimer();
            }
        }).start();
    }
}
