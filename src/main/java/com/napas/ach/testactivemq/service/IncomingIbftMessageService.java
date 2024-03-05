/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.napas.ach.testactivemq.service;

import com.napas.ach.testactivemq.config.AppConfig;
import com.napas.ach.testactivemq.model.IbftMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Slf4j
@Service
public class IncomingIbftMessageService  {
    @Autowired
    private JmsTemplate jmsTemplate;
    
    @Autowired
    private AppConfig config;
    
    public ResponseEntity<?> receiveMessage(IbftMessage msg) {
        String refId = msg.getRefId();
        int queueId = refId.codePointAt(refId.length() - 2)%config.getQueues();
        String destination = "queue-" + queueId;
        
        log.info("Day ban tin den:{} noi dung:{}", destination, msg);
        
        jmsTemplate.convertAndSend(destination, msg);
        return ResponseEntity.ok("Nhan thanh cong");
    }
}
