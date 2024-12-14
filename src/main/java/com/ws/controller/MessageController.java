package com.ws.controller;
import com.ws.config.WebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private WebSocketHandler webSocketHandler;

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        webSocketHandler.broadcastMessage(message);
        return "Message sent to all connected users.";
    }
}
