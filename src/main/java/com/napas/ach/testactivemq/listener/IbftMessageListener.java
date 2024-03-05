/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Component.java to edit this template
 */
package com.napas.ach.testactivemq.listener;

import com.napas.ach.testactivemq.model.IbftMessage;
import java.util.logging.Level;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author nguye
 */
@Slf4j
@Component
public class IbftMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            try {
                Destination destination = message.getJMSDestination();
                log.info("Nhan tu queue:" + destination.toString());
                ObjectMessage objectMessage = (ObjectMessage) message;
                IbftMessage customer = (IbftMessage) objectMessage.getObject();
                log.info("Received ibft message: " + customer.toString());
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException ex) {
                    java.util.logging.Logger.getLogger(IbftMessageListener.class.getName()).log(Level.SEVERE, null, ex);
                }
                log.info("Finish process ibft message: " + customer.toString());
            } catch (JMSException ex) {
                log.error(ex.getMessage());
            }
        }
        
        
    }
}
