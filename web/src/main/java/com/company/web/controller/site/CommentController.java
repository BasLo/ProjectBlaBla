package com.company.web.controller.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {

    @RequestMapping(value = "/test")
    public String testSaveComment(){
        return "afwf";
    }
}