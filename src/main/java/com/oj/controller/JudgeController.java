package com.oj.controller;

import com.oj.bean.OrdinaryUser;
import com.oj.bean.Subject;
import com.oj.bean.SubjectSubmit;
import com.oj.dao.OrdinaryUserRepository;
import com.oj.dao.SubjectRepository;
import com.oj.dao.SubjectSubmitRepository;
import com.oj.service.JudgeService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
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
    @Autowired
    private SubjectSubmitRepository subjectSubmitRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private OrdinaryUserRepository ordinaryUserRepository;

    @RequestMapping("/judgeCode")
    public String JudgeCode(ModelMap model, HttpServletRequest request) throws IOException {
        //获取题目号、编程语言、代码
        String clanguage = request.getParameter("clanguage");
        String codes = request.getParameter("codes");
        String sNum = request.getParameter("sNum");
        Subject subject = subjectRepository.findBySnum(Integer.parseInt(sNum));
        Integer subcount = subject.getSAllSubmit() + 1;
        subject.setSAllSubmit(subcount);
        //获取题目答案提交时间
        Date submitTime = new Date();
        System.out.println("题目提交时间为：" + judgeService.formateDate(submitTime));
        SubjectSubmit subjectSubmit = new SubjectSubmit();
        subjectSubmit.setSsCodeLength(codes.length());
        subjectSubmit.setSsLanguage(clanguage);
        subjectSubmit.setSsTime(new Date());
        subjectSubmit.setSId(subjectRepository.findBySnum(Integer.parseInt(sNum)));
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
        Integer ousubcount = ou.getOuAllSubmit() + 1;
        ou.setOuAllSubmit(ousubcount);
        subjectSubmit.setOuId(ou);
        String sourceFileName = ou.getOuId() + sNum + hz;
        File file = new File("G:/codes/" + sourceFileName);
        String basename = FilenameUtils.getBaseName(file.getName());

        if (!file.exists()) {
            file.createNewFile();
        }

        System.out.println("源文件名为：" + sourceFileName);
        System.out.println("整形题目号为：" + Integer.valueOf(sNum));
        //判断是否存储成功
        boolean writeFlag = judgeService.writeFile(codes, file);

        if (writeFlag) {
            //进入编译阶段
            String result = judgeService.complierCode(file);
            System.out.println("编译结果的长度为：" + result.length());
            System.out.println(result);
            if (result.length() == 0) {
                System.out.println("编译成功");
                subjectSubmit.setSsCompileInfo("编译成功");
                long starttime = System.currentTimeMillis();
                boolean runflag = judgeService.runCode(basename);
                long endtime = System.currentTimeMillis();
                long times = endtime - starttime;
                subjectSubmit.setSsRuntime(times);
                if (runflag) {


                    model.addAttribute("message", "运行成功");
                    subjectSubmit.setSsResult("运行成功");
                    Integer passcount = subject.getSAllPass() + 1;
                    subject.setSAllPass(passcount);
                    subject.setPassRate(((double) passcount / (double) subcount));
                    ou.setOuAllPass(ou.getOuAllPass() + 1);
                    ou.setOuPassRate((double) ou.getOuAllPass() / (double) (ou.getOuAllSubmit() + 1));
                } else {
                    model.addAttribute("message", "结果不正确");
                    subjectSubmit.setSsResult("运行失败");
                }
            } else {
                System.out.println("编译失败");
                subjectSubmit.setSsResult("编译失败");
                subjectSubmit.setSsCompileInfo("编译失败");
                model.addAttribute("message", "编译失败");
                subject.setPassRate(((double) subject.getSAllPass() / (double) subcount));
            }

        } else {
            model.addAttribute("message", "源文件未能正确存入，可能的原因为磁盘内存不够或路径异常");
        }
        request.getSession().setAttribute("subject", subject);
        model.addAttribute("clanguage", clanguage);
        model.addAttribute("code", codes);
        model.addAttribute("subject", subject);

        ordinaryUserRepository.save(ou);
        subjectSubmitRepository.save(subjectSubmit);
        subjectRepository.save(subject);
        return "ordinarySubject/subject_info";
    }
}
