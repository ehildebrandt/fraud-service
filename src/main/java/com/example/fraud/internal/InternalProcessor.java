package com.example.fraud.internal;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InternalProcessor {

    private final InternalChannels internalChannels;

    @StreamListener(InternalChannels.INPUT)
    public void onMessage(String input) {
        internalChannels.output().send(MessageBuilder.withPayload(input.toUpperCase()).build());
    }

}

