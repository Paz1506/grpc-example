package com.zaytsevp.baeldunggrpcexample;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Pavel Zaytsev
 */
public class gRPCClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8000)
                                                      .usePlaintext()
                                                      .build();

        // blocking
        // There are two other types of stubs provided by gRPC, which facilitate non-blocking/asynchronous calls.
        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse response = stub.hello(HelloRequest.newBuilder()
                                                        .setFirstName("Test")
                                                        .setLastName("Testov")
                                                        .build());

        System.out.println(String.format("Received greeting response: %s", response));

        channel.shutdown();
    }
}
