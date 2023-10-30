package com.presstwo.stata.service;

import com.presstwo.stata.entity.Input;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class InputConsumer {
    private static final Logger log = LoggerFactory.getLogger(InputConsumer.class);

    @Bean
    public Consumer<Input> consumeRecord() {
        return input -> {
            log.info("Stata is getting input with the details : " +  input.toString());

        };
    }
}
