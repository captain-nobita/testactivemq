/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.napas.ach.testactivemq.controllers;

import com.napas.ach.testactivemq.model.IbftMessage;
import com.napas.ach.testactivemq.service.IncomingIbftMessageService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author huynx
 */
@RestController
@RequestMapping("/api/")
public class IncomingIbftMessageController {

    @Autowired
    private IncomingIbftMessageService incomingMessageService;
    
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PostMapping
    public ResponseEntity<?> receiverMessage(@RequestBody IbftMessage msg) {
        return incomingMessageService.receiveMessage(msg);
    }
}
