package com.example.fraud.internal

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.test.binder.MessageCollector
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import spock.lang.Specification

import java.util.concurrent.BlockingQueue

@SpringBootTest
class InternalProcessorSpec extends Specification {

    @Autowired
    private InternalChannels internalChannels

    @Autowired
    private MessageCollector collector

    def "should uppercase messages"() {
        when:
        internalChannels.input().send(MessageBuilder.withPayload("Hello World!").build())
        BlockingQueue<Message<?>> messages = collector.forChannel(internalChannels.output())

        then:
        messages.size() == 1
        messages.getAt(0).payload == "HELLO WORLD!"
    }


}
