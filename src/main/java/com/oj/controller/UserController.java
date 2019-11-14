package com.oj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("index")
    public String index(){
        return "/index/index.html";
    }
}
