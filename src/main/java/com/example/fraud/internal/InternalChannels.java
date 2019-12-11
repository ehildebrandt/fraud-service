package com.example.fraud.internal;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface InternalChannels {

    String OUTPUT = "internal-output";

    @Output(OUTPUT)
    MessageChannel output();

    String INPUT = "internal-input";

    @Input(INPUT)
    SubscribableChannel input();

}
