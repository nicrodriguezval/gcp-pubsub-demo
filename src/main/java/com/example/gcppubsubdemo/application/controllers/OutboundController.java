package com.example.gcppubsubdemo.application.controllers;

import com.example.gcppubsubdemo.infrastructure.config.OutboundConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/outbound")
public class OutboundController {
    private final OutboundConfiguration.PubSubOutboundGateway messagingGateway;

    @PostMapping("/send")
    public void sendMessage(@RequestBody String message) {
        log.info("Sending message: {}", message);
        messagingGateway.sendToPubsub(message);
    }
}
