package com.zaytsevp.baeldunggrpcexample;

import io.grpc.stub.StreamObserver;

import static com.zaytsevp.baeldunggrpcexample.HelloServiceGrpc.HelloServiceImplBase;

/**
 * @author Pavel Zaytsev
 */
public class HelloServiceImpl extends HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = "Hello, " +
                          request.getFirstName() +
                          " " +
                          request.getLastName();

        HelloResponse response = HelloResponse.newBuilder()
                                              .setGreeting(greeting)
                                              .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
