package com.oj.controller;

import com.oj.bean.*;
import com.oj.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private NoticeRepository noticeRepository;

    @RequestMapping("/home_menu")
    public String homeMenu(ModelMap model) {

        return "ordinaryMenu/home_menu";
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


    @RequestMapping("/faqContent")
    public String readFaq() throws FileNotFoundException {
        InputStream f = new FileInputStream("static/FAQ.md");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(f));
        System.out.println(buffer.toString());
        return buffer.toString();
    }
}
