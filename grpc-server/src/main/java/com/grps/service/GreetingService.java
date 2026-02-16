package com.grps.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import com.grpc.GreetRequest;
import com.grpc.GreetResponse;
import com.grpc.GreetServiceGrpc;

@GrpcService
public class GreetingService extends GreetServiceGrpc.GreetServiceImplBase {
    @Override
    public void greet(GreetRequest request,
            StreamObserver<GreetResponse> responseObserver) {

        String name = request.getName();
        String message = "Hello " + name + " 👋 from gRPC";

        GreetResponse response = GreetResponse.newBuilder()
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
