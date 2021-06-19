package com.annakhuseinova.springcloudstreamsfunctionalstyle.configs;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * This is how we define the logic of stream processing, we do not need to define @StreamListener
 *
 * Out of this bean the framework will automatically create channels. But still there is not enough data to which
 * topic to bind the channels. The good option is to define them in application.yml under spring.cloud.stream.bindings.
 * <binding-name>.destination
 * */
@Configuration
public class ListenerService {

    @Bean
    public Function<KStream<String, String>, KStream<String, String>> process(){
        return input -> input.mapValues(value -> value.toUpperCase());
    }
}
