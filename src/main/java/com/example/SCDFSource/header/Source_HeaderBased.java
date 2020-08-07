//package com.example.SCDFSource.header;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Processor;
//import org.springframework.messaging.support.MessageBuilder;
//
//@EnableBinding(Processor.class)
//public class Source_HeaderBased {
//
//    @Autowired
//    private Processor processor;
//
// refer : https://www.confluent.io/blog/spring-for-apache-kafka-deep-dive-part-2-apache-kafka-spring-cloud-stream/
//    @StreamListener(target = Processor.INPUT)
//    public void sourceListener(String message) { //1message or 2message
//        System.out.println("listen message : " + message);
//        if (message.startsWith("1")) {
//            processor.output()
//                    .send(
//                            MessageBuilder.withPayload(message.toUpperCase())
//                                    .setHeader("key", "1")
//                                    .build()
//                    );
//        } else {
//            processor.output()
//                    .send(
//                            MessageBuilder.withPayload(message)
//                                    .setHeader("key", "")
//                                    .build()
//                    );
//        }
//    }
//}
