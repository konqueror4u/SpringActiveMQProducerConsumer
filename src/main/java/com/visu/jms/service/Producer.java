package com.visu.jms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.visu.jms.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/produce")
public class Producer {

    private JmsTemplate jmsTemplate;
    private Queue queue;

    public Producer(@Autowired  JmsTemplate jmsTemplate, @Autowired Queue queue ){
        this.jmsTemplate =  jmsTemplate;
        this.queue = queue;
    }

    @PostMapping("/message")
    public Order sendMessage(@RequestBody Order order){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String orderAsJson = objectMapper.writeValueAsString(order);
            jmsTemplate.convertAndSend(queue,orderAsJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return order;
    }
}
