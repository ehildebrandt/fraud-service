package com.example.fraud;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface FraudChannels {

    String OUTPUT = "fraud-output";

    @Output(OUTPUT)
    MessageChannel output();

}
