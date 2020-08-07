//package com.example.SCDFSource.routing;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.function.StreamBridge;
//import org.springframework.context.annotation.Bean;
//
//import java.util.function.Consumer;
//
//public class Source_Routing_StreamBridge {
//    @Autowired
//    StreamBridge streamBridge;
//
//    @Bean
//    public Consumer<String> process() {
//        return c -> {
//            if (c.equals("first")) {
//                System.out.println("Sending to first output");
//                streamBridge.send("first-out-0", c);
//            }
//            else {
//                System.out.println("Sending to second output");
//                streamBridge.send("second-out-0", c);
//            }
//        };
//    }
//
//}
