package com.example.springbootdemo.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class QueueConsumerListener
{
    //queue模式的消费者
    @JmsListener(destination="${spring.activemq.queue-name}", containerFactory="queueListener")
    public void readActiveQueue(Object message) throws JMSException {
        if(message instanceof ActiveMQTextMessage){
            log.info(""+message);
            return ;
        }
        ActiveMQObjectMessage activeMQObjectMessage = (ActiveMQObjectMessage)message;

        activeMQObjectMessage.setTrustedPackages(new ArrayList(Arrays.asList("java.lang,java.util,java.sql".split(","))));
        activeMQObjectMessage.setTrustAllPackages(true);
        Map map = (Map)activeMQObjectMessage.getObject();
        System.out.println("queue接受到：" );
        log.info(""+map);
    }
}