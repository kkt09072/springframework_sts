package com.spring1.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class CustomWebSocketHandler extends TextWebSocketHandler {

    private static final List<WebSocketSession> sessionList = new ArrayList<>();
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Open Session : " + session.getId());
        sessionList.add(session);
        session.sendMessage(new TextMessage("채팅 서버 연결 완료"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("Received message: " + message.getPayload() + " from session: " + session.getId());
        session.sendMessage(new TextMessage("변경되었습니다."));
        sendAllSessionToMessage(session, message.getPayload());
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("Error in session " + session.getId() + ": " + exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("Session : "+ session.getId() + " closed");
        sessionList.remove(session);
    }

    private void sendAllSessionToMessage(WebSocketSession self, String msg) {
        for (WebSocketSession session : sessionList) {
            if (!self.getId().equals(session.getId())) {
                try {
                    session.sendMessage(new TextMessage(msg));
                } catch (Exception e) {
                    log.info(e.getMessage());
                }
            }
        }
    }
}
