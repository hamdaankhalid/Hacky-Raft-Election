package com.hamdaankhalid.cliparser;


import com.hamdaankhalid.grpc.RaftServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.HashMap;
import java.util.Map;

public class CommandLineParser {
    public Map<String, Object> parse(String[] args) {
        Map<String, Object> parsedResult = new HashMap<>();
        // get the port for current node, it is also the id of this node
        int port = Integer.parseInt(args[0]);
        parsedResult.put("port", port);

        String id = args[0];
        parsedResult.put("id", id);

        // get the port of the neighbors
        Map<String, RaftServiceGrpc.RaftServiceBlockingStub> neighbors = new HashMap<>();
        for (int i = 1; i < args.length; i++) {
            String target = "localhost:"+args[i];
            ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
            RaftServiceGrpc.RaftServiceBlockingStub blockingStub = RaftServiceGrpc.newBlockingStub(channel);
            neighbors.put(args[i], blockingStub);
        }
        parsedResult.put("neighbors", neighbors);

        return parsedResult;
    }
}
