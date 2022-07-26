package com.hamdaankhalid;

import com.hamdaankhalid.cliparser.CommandLineParser;
import com.hamdaankhalid.communication.RaftService;
import com.hamdaankhalid.consensus.Consensus;
import com.hamdaankhalid.grpc.RaftServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Object> parsedOptions = new CommandLineParser().parse(args);

        // This is dirty code I know
        String id = (String) parsedOptions.get("id");

        int port = (int) parsedOptions.get("port");
        Map<String, RaftServiceGrpc.RaftServiceBlockingStub> neighbors = (Map<String, RaftServiceGrpc.RaftServiceBlockingStub>) parsedOptions.get("neighbors");
        System.out.println("Node with ID " + id + " is instantiated to be run on PORT "+ port);

        System.out.println(neighbors.keySet());

        // create object that maintains state
        Timer timer = new Timer();
        Consensus consensus = new Consensus(id, neighbors, timer);

        // start grpc server and give it ability to mutate stateObj
        Server server = ServerBuilder.forPort(port).addService(new RaftService(consensus)).build();

        try {
            server.start();

            System.out.println("Server is up!");

            System.out.println("Press enter to start consensus algorithm");
            scanner.nextLine();

            // starts a thread that runs a timer for leader not contacted
            consensus.leaderNotContactedTimer();

            server.awaitTermination();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            server.shutdown();
            server.shutdownNow();

            timer.cancel();
            timer.purge();
        }
    }
}
