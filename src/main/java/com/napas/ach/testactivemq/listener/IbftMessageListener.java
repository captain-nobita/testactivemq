/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Component.java to edit this template
 */
package com.napas.ach.testactivemq.listener;

import com.napas.ach.testactivemq.model.IbftMessage;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author nguye
 */
@Component
public class IbftMessageListener {
    private static final Logger log = LoggerFactory.getLogger(IbftMessageListener.class);

    @JmsListener(destination = "${queue.name}")
    public void receiveCustomer(IbftMessage customer) {
        log.info("Received ibft message: " + customer.toString());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(IbftMessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        log.info("Finish process ibft message: " + customer.toString());
    }
}
