package com.example.ticketservice.config;
import io.grpc.netty.shaded.io.grpc.netty.NegotiationType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import net.devh.boot.grpc.client.config.GrpcChannelProperties;
import net.devh.boot.grpc.client.config.GrpcChannelsProperties;

@Configuration
public class GrpcClientConfig {
    
    @Value("${grpc.client.sentiment_service.address:static://sentimentservice:9090}")
    private String sentimentServiceAddress;
    
    @Value("${grpc.client.sentiment_service.negotiationType:PLAINTEXT}")
    private String negotiationType;
    
    
    @Bean
    public GrpcChannelsProperties grpcChannelsProperties() {
        GrpcChannelsProperties properties = new GrpcChannelsProperties();
        
        GrpcChannelProperties sentimentServiceProps = new GrpcChannelProperties();
        sentimentServiceProps.setAddress(sentimentServiceAddress);
        sentimentServiceProps.setNegotiationType(NegotiationType.PLAINTEXT);
        
        properties.getChannels().put("sentimentservice", sentimentServiceProps);
        
        return properties;
    }
}
