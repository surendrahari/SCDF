package com.example.SCDFSource.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(MySourceBinding.class)
public class MyCustomSource {

    @Autowired
    private MySourceBinding mySourceBinding; //FIXME : only used for error case

    @StreamListener(MySourceBinding.INPUT)
    public void listen(String message) {
        try {
            mySourceBinding.output()
                    .send(process(message));
        } catch (RuntimeException rte) {
            mySourceBinding.ackoutput()
                    .send(MessageBuilder.withPayload(message).build());
        }
    }

//    @StreamListener(MySourceBinding.INPUT)
//    @SendTo(MySourceBinding.OUTPUT)
    public Message<?> process(String message) {
        System.out.println("message listened :" + message);
        if ("error".startsWith(message.trim())) {
            throw new RuntimeException("check error object:" + message);
        }
        return MessageBuilder.withPayload(message.toUpperCase())
                .build();
    }
}
