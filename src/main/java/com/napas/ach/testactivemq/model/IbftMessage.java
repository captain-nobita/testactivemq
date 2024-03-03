/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.napas.ach.testactivemq.model;

import java.io.Serializable;

/**
 *
 * @author nguye
 */
public class IbftMessage implements Serializable {
    private String senderId;
    private String content;

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "IbftMessage{" + "senderId=" + senderId + ", content=" + content + '}';
    }
    
}
