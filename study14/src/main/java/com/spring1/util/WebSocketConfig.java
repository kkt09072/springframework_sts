package com.spring1.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketConfigurer, WebSocketMessageBrokerConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    	
    	// WebSocket0
        registry.addHandler(new CustomWebSocketHandler(), "/socket.do").setAllowedOrigins("*");
    	
        // WebSocket
        registry.addHandler(new ChatWebSocketHandler(), "/ws/chat").setAllowedOrigins("*");
        
        // SockJS
        registry.addHandler(new ChatSockJsHandler(), "/sockjs/chat").setAllowedOrigins("*").withSockJS();
        
        // STOMP
        registry.addHandler(new ChatStompHandler(), "/stomp/chat").setAllowedOrigins("*").withSockJS();
    }

    @Bean
    public CustomWebSocketHandler customWebSocketHandler() {
        return new CustomWebSocketHandler();
    }
    
    
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stomp/chat").withSockJS();
    }
    
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
    

    
}
