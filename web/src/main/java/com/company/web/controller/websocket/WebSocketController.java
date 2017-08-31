package com.company.web.controller.websocket;

import com.company.domain.pojo.webcosket.Greeting;
import com.company.domain.pojo.webcosket.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/answer")
    public Greeting greeting(HelloMessage message) {
        return new Greeting("Content input msg: " + message.getName() + "!");
    }

}