package com.company.web.controller.websocket;

import com.company.domain.pojo.webcosket.Greeting;
import com.company.domain.pojo.webcosket.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebSocketController {

    @RequestMapping(value = "/ws")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("defaultTemplate");
        modelAndView.addObject("content", "/WEB-INF/template/body/websocket_content.jsp");
        return modelAndView;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/answer")
//    @SendToUser("/topic/answer")
    public Greeting greeting(HelloMessage message) {
        return new Greeting("Content input msg: " + message.getName() + "!");
    }

}