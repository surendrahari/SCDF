package com.example.SCDFSource.custom;

import org.springframework.cloud.stream.messaging.Processor;

public interface MySourceBinding extends Processor, AckOutput {
}
