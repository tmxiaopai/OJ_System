package com.oj.controller;

import com.oj.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author TMXIAOPAI
 * @Package com.oj.controller
 * @Date 2019/11/20-下午4:18
 */
@Controller
public class JudgeController {

    @Autowired
    private JudgeService judgeService;
    @RequestMapping("/judgeCode")
    public String JudgeCode(ModelMap model, HttpServletRequest request) throws IOException {
        //获取题目号、编程语言、代码
        String clanguage = request.getParameter("clanguage");
        String codes=request.getParameter("codes");
        String sNum=request.getParameter("sNum");

        //获取题目答案提交时间
        Date submitTime=new Date();
        System.out.println("题目提交时间为："+submitTime.toString());

        //获取用户ID，拼接题目号，构成源文件的文件名
        String ouId=(String) request.getSession().getAttribute("ouId");
        String sourceFileName=ouId+sNum+".java";

        System.out.println("源文件名为："+sourceFileName);
        System.out.println("整形题目号为："+Integer.valueOf(sNum));

        boolean writeFlag=judgeService.writeFile(codes,sourceFileName);
        if(writeFlag){

        }else{
            model.addAttribute("message","源文件未能正确存入，可能的原因为磁盘内存不够或路径异常");
        }
        System.out.println("编译结果:"+judgeService.complierCode("M"));
        judgeService.runCode("M");
        judgeService.readFile("output.txt");
        System.out.println(new File("Mrun.txt").length());








        return "initsuccess";
    }
}
