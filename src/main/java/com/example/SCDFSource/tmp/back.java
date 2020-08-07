package com.example.SCDFSource.tmp;

public class back {

//    @StreamListener(Sink.INPUT)
//    public void sinkListener(String sourceMessage,
//                               @Header(AmqpHeaders.CHANNEL) Channel channel,
//                               @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
//                               @Header(AmqpHeaders.REDELIVERED) boolean redelivered,
//                               @Header("msgid") String correlationId) throws Exception {
//
//        // check the type of the message (good or error)
//        boolean isAck = sourceMessage.startsWith("ack");
//
//        // DO business logic
//        String returnMessage = sourceMessage.toUpperCase();
//
//        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
//
//        if ( isAck ) {
//            //send ack to sinkQueue
//            channel.basicAck(deliveryTag, false);
//        } else {
//            // Send the ack to Ack queue
//            channel.basicPublish(EXCHANGE_NAME,
//                    ACK_QUEUE,
//                    MessageProperties.PERSISTENT_TEXT_PLAIN,
//                    returnMessage.getBytes()
//            );
//        }
//
//        System.out.println(" message sent ---> ");
//
//    }
//
//    @StreamListener()
//    public void sinkListener(String sourceMessage,
//                             @Header(AmqpHeaders.CHANNEL) Channel channel,
//                             @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
//                             @Header(AmqpHeaders.REDELIVERED) boolean redelivered,
//                             @Header("msgid") String correlationId) throws Exception {
//
//        // check the type of the message (good or error)
//        boolean isAck = sourceMessage.startsWith("ack");
//
//        // DO business logic
//        String returnMessage = sourceMessage.toUpperCase();
//
//        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
//
//        if ( isAck ) {
//            //send ack to sinkQueue
//            channel.basicAck(deliveryTag, false);
//        } else {
//            // Send the ack to Ack queue
//            channel.basicPublish(EXCHANGE_NAME,
//                    ACK_QUEUE,
//                    MessageProperties.PERSISTENT_TEXT_PLAIN,
//                    returnMessage.getBytes()
//            );
//        }
//
//        System.out.println(" message sent ---> ");
//
//    }

    //----------------

    /*@StreamListener(SOURCE)
    public void sourceListener(String sourceMessage,
                               @Header(AmqpHeaders.CHANNEL) Channel channel,
                               @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
                               @Header(AmqpHeaders.REDELIVERED) boolean redelivered,
                               @Header("msgid") String correlationId) throws Exception {

        // check the type of the message (good or error)
        String routingKey = sourceMessage.startsWith("ack") ? "ack" : "msg";

        // DO business logic
        String returnMessage = sourceMessage.toUpperCase();

        channel.queueBind(ACK_QUEUE, Source.OUTPUT, "ack");
        channel.queueBind(Sink.INPUT, Source.OUTPUT, "");

        channel.exchangeDeclare(Source.OUTPUT, "direct");

        if ( isAck ) {
            // Send back the response to the taskQueue
            channel.basicPublish(Source.OUTPUT,
                    ACK_QUEUE,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    returnMessage.getBytes()
            );
        } else {
            // Send back the response to the taskQueue
            channel.basicPublish(Source.OUTPUT,
                    Source.OUTPUT,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    returnMessage.getBytes()
            );
        }

        System.out.println(" message sent ---> ");
    }*/
}
