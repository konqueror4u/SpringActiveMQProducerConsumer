package com.visu.jms.service;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "${activemq.queue}")
    public void consumeMessage(String message) {
        logger.info("Message received from activemq queue---"+message);
    }
}
