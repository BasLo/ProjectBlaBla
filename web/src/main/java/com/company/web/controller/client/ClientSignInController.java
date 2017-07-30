package com.company.web.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientSignInController {

    @RequestMapping(value = "/signInView")
    public ModelAndView signInView(ModelAndView modelAndView) {
        modelAndView.setViewName("defaultTemplate");
        modelAndView.addObject("content", "/WEB-INF/template/body/sign_in_content.jsp");
        return modelAndView;
    }
}
