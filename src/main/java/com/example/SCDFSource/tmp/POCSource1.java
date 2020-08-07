//package com.example.SCDFSource;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.MessageProperties;
//import org.springframework.amqp.support.AmqpHeaders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Processor;
//import org.springframework.cloud.stream.messaging.Source;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.messaging.support.MessageBuilder;
//
//@EnableBinding(Processor.class)
//public class POCSource1 {
//
//    @Autowired
//    private Processor processor;
//
//    @StreamListener(target = Processor.INPUT)
//    public void sourceListener(String message) {
//        System.out.println("listen message : " + message);
//        processor.output()
//                .send(
//                        MessageBuilder.withPayload(message.toUpperCase())
//                                .build()
//                );
//    }
//
//    //@StreamListener(target = MySource.SOURCE)
//    public void sourceListener1(String sourceMessage,
//                                                @Header(AmqpHeaders.CHANNEL) Channel channel,
//                                                @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
//                                                @Header(AmqpHeaders.REDELIVERED) boolean redelivered,
//                                                @Header("msgid") String correlationId) throws Exception {
//
//        // check the type of the message (good or error)
//        String routingKey = sourceMessage.startsWith("ack") ? "ack" : "msg";
//
//        // DO business logic
//        String returnMessage = sourceMessage.toUpperCase();
//
//        channel.exchangeDeclare(Source.OUTPUT, "direct");
//
//        channel.basicPublish(Source.OUTPUT,
//                routingKey,
//                MessageProperties.PERSISTENT_TEXT_PLAIN,
//                returnMessage.getBytes()
//        );
//
//        System.out.println(" message sent ---> ");
//    }
//}
