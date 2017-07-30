package com.company.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("defaultTemplate");
        modelAndView.addObject("content", "/WEB-INF/template/body/content.jsp");
        return modelAndView;
    }
}
