package com.visu.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@ComponentScan(basePackages = "com.visu.jms.*")
public class SpringActiveMQProducerConsumer {

    public static void main(String[] args) {
        SpringApplication.run(SpringActiveMQProducerConsumer.class, args);
    }

}
