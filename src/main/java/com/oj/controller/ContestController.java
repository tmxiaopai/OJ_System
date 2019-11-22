package com.oj.controller;

import com.oj.bean.Contest;
import com.oj.dao.ContestRepository;
import com.oj.dao.ContestSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author TMXIAOPAI
 * @Package com.oj.controller
 * @Date 2019/11/22-下午2:43
 */
@Controller
public class ContestController {
    @Autowired
    private ContestRepository contestRepository;
    @Autowired
    private ContestSubjectRepository contestSubjectRepository;

    @RequestMapping("/contest_list")
    public String contestList(ModelMap model) {
        List<Contest> contests = contestRepository.findAll();
        model.addAttribute("contests", contests);
        return "ordinaryContest/contest_list";
    }

    @RequestMapping("/contest_menu")
    public String contestMenu() {

        return "ordinaryMenu/contest_menu";
    }

    @RequestMapping("/contest_info")
    public String contestInfo(@RequestParam("cId")Integer cId,ModelMap model) {
        System.out.println("竞赛ID为："+cId);
        Contest contest=contestRepository.getOne(cId);
        System.out.println(contest.getCName());
        model.addAttribute("thiscontest",contest);
        return "ordinaryContest/contest_info";
    }

    @RequestMapping("/contest_rank")
    public String contestRank() {
        return "ordinaryContest/contest_rank";
    }
}
