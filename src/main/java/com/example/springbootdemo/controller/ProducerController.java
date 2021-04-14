package com.example.springbootdemo.controller;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProducerController
{
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @PostMapping("/queue/test")
    public String sendQueue(@RequestBody String str) throws JMSException {
//        this.sendMessage(this.queue, str);
        HashMap<String,Object> message = new HashMap<>(3);
        message.put("content",str);
        ActiveMQObjectMessage activeMQObjectMessage = new ActiveMQObjectMessage();
        activeMQObjectMessage.setObject(message);
        activeMQObjectMessage.setTrustedPackages(new ArrayList(Arrays.asList("java.lang,java.util,java.sql".split(","))));
        activeMQObjectMessage.setTrustAllPackages(true);
        //需要设置信任哪些包  //设置这样表示信任所有
        jmsMessagingTemplate.convertAndSend(this.queue, activeMQObjectMessage);
        return "success";
    }

    @PostMapping("/topic/test")
    public String sendTopic(@RequestBody String str) {
        this.sendMessage(this.topic, str);
        return "success";
    }

    // 发送消息，destination是发送到的队列，message是待发送的消息
    private void sendMessage(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}