/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.napas.ach.testactivemq.service;

import com.napas.ach.testactivemq.config.ActiveMQConfiguration;
import com.napas.ach.testactivemq.model.IbftMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Service
public class IncomingIbftMessageService {
    private static Logger log = LoggerFactory.getLogger(IncomingIbftMessageService.class);
    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    public ResponseEntity<?> receiveMessage(IbftMessage msg) {
        jmsTemplate.convertAndSend(msg.getSenderId(), msg);
        return ResponseEntity.ok("Nhan thanh cong");
    }
}
