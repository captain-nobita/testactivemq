/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.napas.ach.testactivemq.config;

import com.napas.ach.testactivemq.listener.IbftMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author huynx
 */
@Slf4j
@Component
public class MyJmsListenerConfigurer implements JmsListenerConfigurer {
    @Autowired
    private AppConfig config;
    
    @Override
    public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
        // Cấu hình các endpoint nghe tin nhắn JMS ở đây
        // Ví dụ: 
        
        for(int i = 0; i < config.getQueues(); i++) {
            SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
            endpoint.setId("Listener-" + i);
            
            String destination = "queue-" + i;
            endpoint.setDestination(destination);
            endpoint.setMessageListener(new IbftMessageListener());
            registrar.registerEndpoint(endpoint);
            
            log.info("Da tao:" + destination);
        }
    }
}
