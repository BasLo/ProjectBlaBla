package com.company.web.controller.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/news")
public class NewsController {

    @RequestMapping(value = "/")
    public ModelAndView news(ModelAndView model) {
        model.setViewName("index/news");
        return model;
    }

}