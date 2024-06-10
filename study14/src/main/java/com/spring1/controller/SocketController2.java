package com.spring1.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SocketController2 {

    @GetMapping("/websocket")
    public String websocketChat() {
        return "websocket";
    }

    @GetMapping("/sockjs")
    public String sockjsChat() {
        return "sockjs";
    }

    @GetMapping("/stomp")
    public String stompChat() {
        return "stomp";
    }
    

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public String handleChatMessage(String message) {
        return message;
    }
   
}
