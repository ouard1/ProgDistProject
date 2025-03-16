package com.example.ticketservice.service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.sentimentservice.grpc.SentimentRequest;
import com.example.sentimentservice.grpc.SentimentResponse;
import com.example.sentimentservice.grpc.SentimentServiceGrpc;
@Service
public class SentimentAnalysisClient {

    private static final Logger logger = LoggerFactory.getLogger(SentimentAnalysisClient.class);

    @GrpcClient("sentimentservice")
    private SentimentServiceGrpc.SentimentServiceBlockingStub sentimentServiceStub;

    public String analyzeSentiment(String text) {
        logger.info("Analyzing sentiment for text: {}", text);
        try {
            SentimentRequest request = SentimentRequest.newBuilder()
                    .setText(text)
                    .build();

            SentimentResponse response = sentimentServiceStub.analyzeSentiment(request);
            logger.info("Received sentiment: {}", response.getSentiment());
            return response.getSentiment();
        } catch (Exception e) {
            logger.error("Error calling sentiment service", e);
            return "neutral"; 
        }
    }
}
