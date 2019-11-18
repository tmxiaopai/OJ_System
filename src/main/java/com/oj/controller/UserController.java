package com.oj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/")
    public String home(){
        return "ordinaryMenu/home";
    }
    @RequestMapping("/home_menu")
    public String homeMenu(){
        return "ordinaryMenu/home_menu";
    }
    @RequestMapping("/contest_list")
    public String contestMenu(){
        return "ordinaryContest/contest_list";
    }
    @RequestMapping("/subject_menu")
    public String subjectMenu(){
        return "ordinaryMenu/subject_menu";
    }
    @RequestMapping("/notice")
    public String notice(){
        return "ordinaryHome/notice";
    }
    @RequestMapping("/faq")
    public String faq(){
        return "ordinaryHome/faq";
    }
    @RequestMapping("/sub")
    public String sub(){
        return "ordinarySubject/submitandjudge";
    }
}
