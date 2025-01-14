package com.example.gcppubsubdemo.infrastructure.config;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;

@Configuration
@RequiredArgsConstructor
public class OutboundConfiguration {
    private final PubSubConfiguration pubSubConfiguration;

    @Bean
    @ServiceActivator(inputChannel = "outputMessageChannel")
    public MessageHandler messageHandler(PubSubTemplate pubSubTemplate) {
        return new PubSubMessageHandler(pubSubTemplate, pubSubConfiguration.getTopic());
    }

    @MessagingGateway(defaultRequestChannel = "outputMessageChannel")
    public interface PubSubOutboundGateway {
        void sendToPubsub(String text);
    }
}
