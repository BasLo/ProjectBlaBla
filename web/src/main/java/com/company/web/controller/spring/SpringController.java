package com.company.web.controller.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringController {

    @RequestMapping(value = "/access_denied_view")
    public ModelAndView accessDenied(ModelAndView modelAndView) {
        modelAndView.setViewName("defaultTemplate");
        modelAndView.addObject("content", "/WEB-INF/template/body/access_denied_content.jsp");
        return modelAndView;
    }
}
