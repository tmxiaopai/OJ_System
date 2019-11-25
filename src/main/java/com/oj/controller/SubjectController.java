package com.oj.controller;

import com.oj.bean.OrdinaryUser;
import com.oj.bean.Subject;
import com.oj.bean.SubjectSubmit;
import com.oj.dao.OrdinaryUserRepository;
import com.oj.dao.SubjectRepository;
import com.oj.dao.SubjectSubmitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author TMXIAOPAI
 * @Package com.oj.controller
 * @Date 2019/11/22-下午3:25
 */
@Controller
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectSubmitRepository subjectSubmitRepository;
    @Autowired
    private OrdinaryUserRepository ordinaryUserRepository;

    @RequestMapping("/subject_menu")
    public String subjectMenu() {
        return "ordinaryMenu/subject_menu";
    }

    @RequestMapping("/item_bank")
    public String itemBank(ModelMap model) {
        int allSubmitCount = (int) subjectSubmitRepository.count();
        int subjectCount = (int) subjectRepository.count();
        int allpassCount = subjectSubmitRepository.countPass().size();
        float passRate = (float) allpassCount / (float) allSubmitCount * 100;
        System.out.println(passRate);
        model.addAttribute("subCount", subjectCount);
        model.addAttribute("allSubmitCount", allSubmitCount);
        model.addAttribute("passRate", String.format("%.2f", passRate));
        return "ordinarySubject/item_bank";
    }

    @RequestMapping("/searchByDegree")
    public String searchByDegree(@RequestParam("degree") short degree, ModelMap model) {

        List<Subject> subjects = null;
        subjects = subjectRepository.findByDegree(degree);
        model.addAttribute("subjects", subjects);
        return "ordinarySubject/subject_list";
    }

    @RequestMapping("/subject_list")
    public String subjectList(ModelMap model) {
        List<Subject> subjects = subjectRepository.findAll();
        model.addAttribute("subjects", subjects);
        return "ordinarySubject/subject_list";
    }

    @RequestMapping("/searchSubject")
    public String searchSubject(ModelMap model, HttpServletRequest request) {
        String content = request.getParameter("content");


        //提取在字符串中的数字
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(content);
        String str = m.replaceAll("").trim();
        Integer num = 0;
        if (!str.equals("")) {
            num = Integer.parseInt(str);
        }

        List<Subject> subjects = null;

        if (content.equals("") && num == null) {
            subjectRepository.findAll();
        } else {
            subjects = subjectRepository.findAllBysName(content, num);
        }


        if (subjects.size() == 0) {
            subjects = subjectRepository.findAll();
            model.addAttribute("message", "meiyozhaodaoxiangguanjilu");
        }

        model.addAttribute("subjects", subjects);
        return "ordinarySubject/subject_list";
    }

    @RequestMapping("/subjectInfo")
    public String subjectInfo(@RequestParam("sid") Integer sid, ModelMap model,HttpServletRequest request) {
        System.out.println(sid);
        Subject subject = subjectRepository.getOne(sid);
        request.getSession().setAttribute("subject",subject);
        model.addAttribute("subject", subject);
        return "ordinarySubject/subject_info";
    }

    @RequestMapping("/rank_list")
    public String rankList(ModelMap model) {
        List<OrdinaryUser> ordinaryUsers = ordinaryUserRepository.rankListByPassCount();
        model.addAttribute("users", ordinaryUsers);

        return "ordinarySubject/rank_list";
    }

    @RequestMapping("/submit_list")
    public String submitList(ModelMap model,HttpServletRequest request) {
        OrdinaryUser ou = (OrdinaryUser) request.getSession().getAttribute("ou");
        List<SubjectSubmit> subjectSubmits =null;

        if(ou!=null){
            Integer OuId=ou.getOuId();
            subjectSubmits=subjectSubmitRepository.findByOUID(ou);
        }else {
            subjectSubmits = subjectSubmitRepository.findAll();
        }

        model.addAttribute("submits", subjectSubmits);
        return "ordinarySubject/submit_list";
    }
}
