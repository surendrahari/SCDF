package com.example.SCDFSource.routing;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Processor.class)
public class Source_RoutingBased {

    private static final String PROCESS_QUEUE = "processQueue";
    private static final String ACKNOWLEDGE_QUEUE = "acknowledgeQueue";

    @Autowired
    private AmqpTemplate amqpTemplate;

    @StreamListener(target = Sink.INPUT)
    public void myListener(String message) { //1messge -> routing queue 1
        System.out.println("message received : " + message);

        String queueName = PROCESS_QUEUE;
        Message<?> messageObject = null;
        try {
            messageObject = process(message);
        } catch (RuntimeException rte) {
            queueName = ACKNOWLEDGE_QUEUE;
            messageObject = MessageBuilder.withPayload(message).build();
        } finally {
            amqpTemplate.convertAndSend(Processor.OUTPUT, queueName, messageObject);
        }
    }

    public Message<?> process(String message) {
        // read, parse, validate, enrich
        System.out.println("read..parse...validate...enrich...completed : " + message);
        if (message.startsWith("error")) {
            throw new RuntimeException("process error");
        }
        return MessageBuilder.withPayload(message).build();
    }
}
