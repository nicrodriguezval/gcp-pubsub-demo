package com.example.gcppubsubdemo.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "application.pubsub")
public class PubSubConfiguration {
    private String topic;
    private String subscription;
}
