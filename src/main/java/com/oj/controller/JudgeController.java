package com.oj.controller;

import com.oj.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

/**
 * @author TMXIAOPAI
 * @Package com.oj.controller
 * @Date 2019/11/20-下午4:18
 */
@Controller
public class JudgeController {

    @Autowired
    private JudgeService judgeService;
    @RequestMapping("/judge")
    public String xiangtong() throws IOException {
        System.out.println("编译结果:"+judgeService.complierCode("M"));
        judgeService.runCode("M");
        judgeService.readFile("output.txt");
        System.out.println(new File("Mrun.txt").length());
        return "initsuccess";
    }
}
