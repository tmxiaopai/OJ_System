package com.oj.controller;

import com.oj.bean.OrdinaryUser;
import com.oj.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
        String codes = request.getParameter("codes");
        String sNum = request.getParameter("sNum");

        //获取题目答案提交时间
        Date submitTime = new Date();
        System.out.println("题目提交时间为：" + judgeService.formateDate(submitTime));
        //文件类型选择
        String hz = null;
        switch (clanguage) {
            case "java":
                hz = ".java";
                break;
            case "python":
                hz = ".py";
                break;
            case "c":
                hz = ".c";
                break;
            case "cpp":
                hz = ".cpp";
                break;
        }


        //获取用户ID，拼接题目号，构成源文件的文件名
        OrdinaryUser ou = (OrdinaryUser) request.getSession().getAttribute("ou");
        String sourceFileName = ou.getOuId() + sNum + hz;
        /*File file = new File("/home/OJ_Subject/"+sourceFileName);
        if(!file.exists()){
            file.createNewFile();
        }*/

        System.out.println("源文件名为：" + sourceFileName);
        System.out.println("整形题目号为：" + Integer.valueOf(sNum));
        //判断是否存储成功
        boolean writeFlag = judgeService.writeFile(codes, sourceFileName);

        if (writeFlag) {
            //进入编译阶段
            String result = judgeService.complierCode(sourceFileName);
            String comFile = ou.getOuId() + sNum + "com.txt";
            if(judgeService.writeFile(result, comFile)){

            }
            if () {
                System.out.println("编译成功");
                judgeService.runCode("");

            } else {
                System.out.println("便以失败");
                model.addAttribute("message", "编译失败");
            }

        } else {
            model.addAttribute("message", "源文件未能正确存入，可能的原因为磁盘内存不够或路径异常");
        }
        //System.out.println("编译结果:"+judgeService.complierCode("M"));
        //judgeService.runCode("M");
        // judgeService.readFile("output.txt");
        //System.out.println(new File("Mrun.txt").length());


        return "initsuccess";
    }
}
