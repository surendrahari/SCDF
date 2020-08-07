//package com.example.SCDFSource.routing;
//
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Processor;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.support.MessageBuilder;
//
//import java.util.Random;
//
//@EnableBinding(Processor.class)
//public class Source_Routing_SourceBased {
//
//    private static final Random RANDOM = new Random(System.currentTimeMillis());
//
//    // We use a strategy so that this data will end up in a partition,
//    // P = L(x) - 1 where L is a length function on the payload.
//    private static final String[] data = new String[]{
//            "f", "g", "h", //making them go to partition-0 by making a single char string
//            "fo", "go", "ho",
//            "foo", "goo", "hoo",
//            "fooz", "gooz", "hooz"
//    };
//
//    @StreamListener(target = Processor.INPUT)
//    @SendTo(Processor.OUTPUT)
//    public Message<?> generate(String msg) {
//        String value = data[RANDOM.nextInt(data.length)];
//        // FIXME doesn't work :: if ("error".startsWith(msg.trim())) throw new RuntimeException("exception :" + msg + " " + value);
//        System.out.println("Sending: " + value);
//        return MessageBuilder.withPayload(value)
//                .setHeader("partitionKey", value.length())
//                .build();
//    }
//}
