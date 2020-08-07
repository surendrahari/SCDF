//package com.example.SCDFSource;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.DeliverCallback;
//import org.springframework.amqp.support.AmqpHeaders;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
//import org.springframework.messaging.handler.annotation.Header;
//
//@EnableBinding(Sink.class)
//public class POCSink {
//
//    @StreamListener(Sink.INPUT)
//    public void sinkListener(String sourceMessage,
//                             @Header(AmqpHeaders.CHANNEL) Channel channel,
//                             @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
//                             @Header(AmqpHeaders.REDELIVERED) boolean redelivered,
//                             @Header("msgid") String correlationId) throws Exception {
//
//        String queueName = channel.queueDeclare().getQueue();
//
//        // check the type of the message (good or error)
//        String routingKey = sourceMessage.startsWith("ack") ? "ack" : "msg";
//
//        channel.queueBind(queueName, Sink.INPUT, routingKey);
//
//        System.out.println(" [*] Waiting for messages.....");
//
//        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//            String message = new String(delivery.getBody(), "UTF-8");
//            System.out.println(" [x] Received '" + delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
//        };
//        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
//    }
//}
