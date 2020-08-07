package com.example.SCDFSource.custom;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface AckOutput {
    String ACKOUTPUT = "ackoutput";

    @Output("ackoutput")
    MessageChannel ackoutput();
}


//(input)
//mb rabbit <- source -> sink outbound rabbit mq        <- sink ( DB )
//                     -> ackout ( failover / success ) <- sink