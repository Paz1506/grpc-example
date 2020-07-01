package com.zaytsevp.baeldunggrpcexample;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Pavel Zaytsev
 */
@Component
public class GrpcServerRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Server server = ServerBuilder.forPort(8000)
                                     .addService(new HelloServiceImpl())
                                     .build();

        System.out.println("Server created!");
        server.start();
        System.out.println("Server started!");
        server.awaitTermination();
    }
}
