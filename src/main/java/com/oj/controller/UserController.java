package com.oj.controller;

import com.oj.bean.*;
import com.oj.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class UserController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private OrdinaryUserRepository ordinaryUserRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ContestRepository contestRepository;
    @Autowired
    private ContestSubjectRepository contestSubjectRepository;
    @Autowired
    private NoticeRepository noticeRepository;
    @Autowired
    private SubjectSubmitRepository subjectSubmitRepository;

    @RequestMapping("/")
    public String home() {
        return "ordinaryMenu/home";
    }

    @RequestMapping("/home_menu")
    public String homeMenu(ModelMap model) {

        return "ordinaryMenu/home_menu";
    }

    @RequestMapping("/contest_list")
    public String contestList(ModelMap model) {
        List<Contest> contests = contestRepository.findAll();
        model.addAttribute("contests", contests);
        return "ordinaryContest/contest_list";
    }

    @RequestMapping("/subject_menu")
    public String subjectMenu() {
        return "ordinaryMenu/subject_menu";
    }

    @RequestMapping("/contest_menu")
    public String contestMenu() {
        return "ordinaryMenu/contest_menu";
    }

    @RequestMapping("/notice")
    public String notice(ModelMap model) {
        List<Notice> notices = noticeRepository.findAll();
        model.addAttribute("notices", notices);
        return "ordinaryHome/notice";
    }

    @RequestMapping("/faq")
    public String faq() {
        return "ordinaryHome/faq";
    }

    @RequestMapping("/sub")
    public String sub() {
        return "ordinarySubject/submitandjudge";
    }

    @RequestMapping("/item_bank")
    public String itemBank(ModelMap model) {
        int allSubmitCount = 180;
        int subjectCount = (int) subjectRepository.count();
        int allpassCount = 12;
        float passRate = (float) allpassCount / (float) allSubmitCount * 100;
        System.out.println(passRate);
        model.addAttribute("subCount", subjectCount);
        model.addAttribute("allSubmitCount", allSubmitCount);
        model.addAttribute("passRate", String.format("%.2f", passRate));
        return "ordinarySubject/item_bank";
    }

    @RequestMapping("/subject_list")
    public String subjectList(ModelMap model) {
        List<Subject> subjects = subjectRepository.findAll();
        model.addAttribute("subjects", subjects);
        return "ordinarySubject/subject_list";
    }

    @RequestMapping(value = "/searchSubject")
    public String searchSubject(ModelMap model, HttpServletRequest request) {
        String content = request.getParameter("content");


        //提取在字符串中的数字
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(content);
        String str = m.replaceAll("").trim();
        Integer num=0;
        if(!str.equals("")){
             num = Integer.parseInt(str);
        }

        List<Subject> subjects = null;

        if (content.equals("") && num == null) {
            subjectRepository.findAll();
        } else {
            subjects = subjectRepository.findAllBysName(content, num);
        }


        System.out.println(subjects.size());
        model.addAttribute("subjects", subjects);
        return "ordinarySubject/subject_list";
    }


    @RequestMapping("/rank_list")
    public String rankList(ModelMap model) {
        List<OrdinaryUser> ordinaryUsers = ordinaryUserRepository.rankListByPassCount();
        model.addAttribute("users", ordinaryUsers);

        return "ordinarySubject/rank_list";
    }

    @RequestMapping("/submit_list")
    public String submitList(ModelMap model) {
        List<SubjectSubmit> subjectSubmits = subjectSubmitRepository.findAll();
        model.addAttribute("submits", subjectSubmits);
        return "ordinarySubject/submit_list";
    }

    @RequestMapping("/contest_info")
    public String contestInfo() {
        return "ordinaryContest/contest_info";
    }

    @RequestMapping("/contest_rank")
    public String contestRank() {
        return "ordinaryContest/contest_rank";
    }

    @RequestMapping("/subject_submit")
    public String subjectSubmit() {
        return "ordinarySubject/submitandjudge";
    }

    @RequestMapping("/faqContent")
    public String readFaq() throws FileNotFoundException {
        InputStream f = new FileInputStream("static/FAQ.md");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(f));
        System.out.println(buffer.toString());
        return buffer.toString();
    }


}
