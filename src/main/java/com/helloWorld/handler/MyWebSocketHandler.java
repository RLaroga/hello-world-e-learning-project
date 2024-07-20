package com.helloWorld.handler;

import com.helloWorld.entities.User;
import com.helloWorld.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.logging.Logger;

@RequiredArgsConstructor
public class MyWebSocketHandler extends AbstractWebSocketHandler {

    private static final Logger logger = Logger.getLogger(MyWebSocketHandler.class.getName());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("Connected: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("Received: " + message.getPayload());
        session.sendMessage(new TextMessage("Echo: "+ message.getPayload()));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("Disconnected: " + session.getId());
    }

}
