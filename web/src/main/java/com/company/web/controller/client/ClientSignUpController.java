package com.company.web.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientSignUpController {

    @RequestMapping(value = "/signUpView")
    public ModelAndView signUpView(ModelAndView modelAndView){
        modelAndView.setViewName("defaultTemplate");
        modelAndView.addObject("content", "/WEB-INF/template/body/sign_up_content.jsp");
        return  modelAndView;
    }

    @RequestMapping(value = "/signUp")
    public ModelAndView signUp(ModelAndView modelAndView){
        return modelAndView;
    }
}
