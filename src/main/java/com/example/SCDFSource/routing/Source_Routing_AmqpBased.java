package com.example.SCDFSource.routing;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Sink.class)
public class Source_Routing_AmqpBased {

    private static final String TOPIC_OR_EXCHANGE = "output";
    private static final String ROUTING_KEY1 = "org";
    private static final String ROUTING_KEY2 = "ack";

    @Autowired
    private Sink sink;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @StreamListener(target = Sink.INPUT)
    public void myListener(String message) { //1messge -> routing queue 1
        System.out.println("message received : "+ message);
        if ( message.startsWith("1") ) {
            amqpTemplate.convertAndSend(TOPIC_OR_EXCHANGE, ROUTING_KEY1, message);
        } else {
            amqpTemplate.convertAndSend(TOPIC_OR_EXCHANGE, ROUTING_KEY2, message);
        }
    }
}
