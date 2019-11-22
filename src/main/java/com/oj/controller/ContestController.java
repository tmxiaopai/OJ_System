package com.oj.controller;

import com.oj.bean.Contest;
import com.oj.bean.ContestSubject;
import com.oj.bean.Subject;
import com.oj.dao.ContestRepository;
import com.oj.dao.ContestSubjectRepository;
import com.oj.dao.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    private SubjectRepository subjectRepository;
    @Autowired
    private ContestSubjectRepository contestSubjectRepository;

    @RequestMapping("/contest_list")
    public String contestList(ModelMap model) {
        List<Contest> contests = contestRepository.findAll();
        model.addAttribute("contests", contests);
        return "ordinaryContest/contest_list";
    }

    @RequestMapping("/contest_menu")
    public String contestMenu(@RequestParam("cId") Integer cId, HttpServletRequest request) {
        System.out.println("竞赛ID为：" + cId);
        Contest contest = contestRepository.getOne(cId);
        System.out.println(contest.getCName());
        if (contest != null) {
            request.getSession().setAttribute("contest", contest);
        }
        return "ordinaryMenu/contest_menu";
    }

    @RequestMapping("/contest_info")
    public String contestInfo(HttpServletRequest request, ModelMap model) {
        Contest contest = (Contest) request.getSession().getAttribute("contest");
        model.addAttribute("thiscontest", contest);
        return "ordinaryContest/contest_info";
    }

    @RequestMapping("/subjectContest")
    public String contestSubject(HttpServletRequest request, ModelMap model) {
        Contest contest = (Contest) request.getSession().getAttribute("contest");
        List<ContestSubject> contestSubjects = contest.getContestSubjects();
        List<Subject> subjects = new ArrayList<>();
        if (contestSubjects != null) {
            for (ContestSubject cs : contestSubjects) {
                subjects.add(subjectRepository.getOne(cs.getSId().getSId()));
            }
        }
        model.addAttribute("subjects", subjects);
        return "ordinarySubject/subject_list";
    }

    @RequestMapping("/contest_rank")
    public String contestRank() {
        return "ordinaryContest/contest_rank";
    }
}
