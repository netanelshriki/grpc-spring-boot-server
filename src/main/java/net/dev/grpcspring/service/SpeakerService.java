package net.dev.grpcspring.service;

import io.grpc.stub.StreamObserver;
import net.dev.speakers.*;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class SpeakerService extends SpeakerManagerGrpc.SpeakerManagerImplBase {

    @Override
    public void createSpeaker(CreateSpeakerRequest request, StreamObserver<CreateSpeakerResponse> responseObserver) {

        CreateDetails details = CreateDetails.newBuilder().setMessage(request.getName()+" created successfully!")
                .setLastName(request.getLastName())
                .setAge(request.getAge())
                .build();

        CreateSpeakerResponse response = CreateSpeakerResponse.newBuilder()
                .setStatusCode(201)
                .setDetails(details)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteSpeaker(DeleteSpeakerRequest request, StreamObserver<DeleteSpeakerResponse> responseObserver) {

        DeleteDetails details = DeleteDetails.newBuilder()
                .setMessage(request.getId()+" deleted successfully!")
                .build();

        DeleteSpeakerResponse response = DeleteSpeakerResponse.newBuilder()
                .setDetails(details)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
