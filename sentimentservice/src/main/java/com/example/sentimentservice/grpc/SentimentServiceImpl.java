package com.example.sentimentservice.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import sentiment.SentimentProto;
import sentiment.SentimentRequest;
import sentiment.SentimentResponse;
import sentiment.SentimentServiceGrpc;

import java.util.Set;

@GrpcService
public class SentimentServiceImpl extends SentimentServiceGrpc.SentimentServiceImplBase {

    // test set for analysis
    private final Set<String> positiveWords = Set.of("good", "great", "excellent", "happy", "awesome");
    private final Set<String> negativeWords = Set.of("bad", "terrible", "poor", "sad", "awful");

    @Override
    public void analyzeSentiment(SentimentRequest request, StreamObserver<SentimentResponse> responseObserver) {
        String text = request.getText().toLowerCase();
        int positiveCount = 0;
        int negativeCount = 0;

        for (String word : positiveWords) {
            if (text.contains(word)) {
                positiveCount++;
            }
        }
        for (String word : negativeWords) {
            if (text.contains(word)) {
                negativeCount++;
            }
        }

        String sentiment;
        if (positiveCount > negativeCount) {
            sentiment = "positive";
        } else if (negativeCount > positiveCount) {
            sentiment = "negative";
        } else {
            sentiment = "neutral";
        }

        SentimentResponse response = SentimentResponse.newBuilder()
                .setSentiment(sentiment)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
