package com.example.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class FraudControllerV2 {

    private final FraudChannels fraudChannels;

    @PostMapping("/message")
    public void message() {
        log.info("Sending message...");
        fraudChannels.output().send(MessageBuilder.withPayload(
            ImmutableFraud.builder()
                .name("Spock")
                .build())
            .build());
    }

}
