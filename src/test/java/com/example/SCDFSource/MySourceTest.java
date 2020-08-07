//package com.example.SCDFSource;
//
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.messaging.Source;
//import org.springframework.cloud.stream.test.binder.MessageCollector;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = MySource.class)
//@DirtiesContext
//public class MySourceTest {
//
//    @Autowired
//    private Source source;
//
//    @Autowired
//    private MessageCollector messageCollector;
//
//    @Test
//    public void whenSendMessage_thenResponseShouldUpdateText() {
//        source.output()
//                .send(MessageBuilder.withPayload("This is my message")
//                        .build());
//
////        assertEquals("[1]: This is my message", .toString());
//    }
//}
