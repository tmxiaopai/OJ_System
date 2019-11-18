package com.oj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;

@Controller
public class UserController {
    @RequestMapping("/")
    public String home() {
        System.out.println("之前的输出");
        PrintStream oldPrintStream = System.out;
        FileOutputStream bos = null;
        try {
            bos = new FileOutputStream("output.txt");
            System.setOut(new PrintStream(bos));
            System.out.println("之后的输出");
            System.setOut(oldPrintStream);
            System.out.println("最后的输出");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "ordinaryMenu/home";
    }

    @RequestMapping("/home_menu")
    public String homeMenu() {
        return "ordinaryMenu/home_menu";
    }

    @RequestMapping("/contest_list")
    public String contestList() {
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
    public String notice() {
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
    public String itemBank() {
        return "ordinarySubject/item_bank";
    }

    @RequestMapping("/subject_list")
    public String subjectList() {
        return "ordinarySubject/subject_list";
    }

    @RequestMapping("/rank_list")
    public String rankList() {
        return "ordinarySubject/rank_list";
    }

    @RequestMapping("/submit_list")
    public String submitList() {
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
