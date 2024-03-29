package com.oj.controller;

/**
 * @author TMXIAOPAI
 * @date 2019/11/18 - 20:45
 * @package_name com.oj.controller
 */

import com.oj.bean.*;
import com.oj.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class Init {
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


    @RequestMapping("init")
    public String InitData() {
        User user1 = new User("会飞的橘子", "123456", (short) 0, "a@qq.com", "17732188835", "男");
        User user2 = new User("会爬树的猪", "123456", (short) 0, "b@qq.com", "17732188835", "女");
        User user3 = new User("会唱歌的男孩子", "123456", (short) 0, "c@qq.com", "17732188835", "男");
        User user4 = new User("聪明的汪小", "123456", (short) 1, "admin@qq.com", "17732188835", "男");
        User user5 = new User("会飞的橘子2", "123456", (short) 1, "ad@qq.com", "17732188835", "男");

        OrdinaryUser ordinaryUser1 = new OrdinaryUser(0, 0, 0.0, user1);
        OrdinaryUser ordinaryUser2 = new OrdinaryUser(0, 0, 0.0, user2);
        OrdinaryUser ordinaryUser3 = new OrdinaryUser(0, 0, 0.0, user3);

        Administrator administrator1 = new Administrator(user4);
        Administrator administrator2 = new Administrator(user5);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

        ordinaryUserRepository.save(ordinaryUser1);
        ordinaryUserRepository.save(ordinaryUser2);
        ordinaryUserRepository.save(ordinaryUser3);

        administratorRepository.save(administrator1);
        administratorRepository.save(administrator2);

        Subject subject1 = new Subject(3679, "数字之积", 0, 0, 0.0, 1024, 5000, "计算", (short) 0, "tmxf");
        Subject subject2 = new Subject(1293, "生日礼物", 0, 0, 0.0, 1024, 5000, "计算", (short) 1, "tmxf");
        Subject subject3 = new Subject(1325, "采矿", 0, 0, 0.0, 1024, 5000, "计算", (short) 2, "tmxf");

        subjectRepository.save(subject1);
        subjectRepository.save(subject2);
        subjectRepository.save(subject3);

        Contest contest1 = new Contest("大学生程序设计选拔赛1", "HGU University", "这是一个比赛描述，字数可能有一二百字，字数不够只能复制来凑！", 3, (Date) new Date(), (Date) new Date(), 0, false, "123456", administrator1, (short) 0);
        Contest contest2 = new Contest("大学生程序设计选拔赛2", "HGU University", "这是一个比赛描述，字数可能有一二百字，字数不够只能复制来凑！", 3, (Date) new Date(), (Date) new Date(), 0, false, "123456", administrator2, (short) 1);
        Contest contest3 = new Contest("大学生程序设计选拔赛3", "HGU University", "这是一个比赛描述，字数可能有一二百字，字数不够只能复制来凑！", 3, (Date) new Date(), (Date) new Date(), 0, false, "123456", administrator1, (short) 2);

        contestRepository.save(contest1);
        contestRepository.save(contest2);
        contestRepository.save(contest3);

        ContestSubject contestSubject1 = new ContestSubject(0, 0, 0.0, contest1, subject1);
        ContestSubject contestSubject2 = new ContestSubject(0, 0, 0.0, contest1, subject2);
        ContestSubject contestSubject3 = new ContestSubject(0, 0, 0.0, contest1, subject3);
        ContestSubject contestSubject4 = new ContestSubject(0, 0, 0.0, contest2, subject1);
        ContestSubject contestSubject5 = new ContestSubject(0, 0, 0.0, contest2, subject2);
        ContestSubject contestSubject6 = new ContestSubject(0, 0, 0.0, contest2, subject3);
        ContestSubject contestSubject7 = new ContestSubject(0, 0, 0.0, contest3, subject1);
        ContestSubject contestSubject8 = new ContestSubject(0, 0, 0.0, contest3, subject2);
        ContestSubject contestSubject9 = new ContestSubject(0, 0, 0.0, contest3, subject3);

        contestSubjectRepository.save(contestSubject1);
        contestSubjectRepository.save(contestSubject2);
        contestSubjectRepository.save(contestSubject3);
        contestSubjectRepository.save(contestSubject4);
        contestSubjectRepository.save(contestSubject5);
        contestSubjectRepository.save(contestSubject6);
        contestSubjectRepository.save(contestSubject7);
        contestSubjectRepository.save(contestSubject8);
        contestSubjectRepository.save(contestSubject9);

        contest1.getContestSubjects().add(contestSubject1);
        contest1.getContestSubjects().add(contestSubject2);
        contest1.getContestSubjects().add(contestSubject3);
        contest2.getContestSubjects().add(contestSubject1);
        contest2.getContestSubjects().add(contestSubject2);
        contest2.getContestSubjects().add(contestSubject3);
        contest3.getContestSubjects().add(contestSubject1);
        contest3.getContestSubjects().add(contestSubject2);
        contest3.getContestSubjects().add(contestSubject3);

        Notice notice1 = new Notice(new Date(), "Plantform Use", "zhetidaogonggaodeneirongshipinyin,yinweishurufayongbuliaolemeiyoubanfa.", administrator1);
        Notice notice2 = new Notice(new Date(), "Plantform Use", "zhetidaogonggaodeneirongshipinyin,yinweishurufayongbuliaolemeiyoubanfa.", administrator1);
        Notice notice3 = new Notice(new Date(), "Plantform Use", "zhetidaogonggaodeneirongshipinyin,yinweishurufayongbuliaolemeiyoubanfa.", administrator1);

        noticeRepository.save(notice1);
        noticeRepository.save(notice3);
        noticeRepository.save(notice2);

        administrator1.getNotices().add(notice1);
        administrator1.getNotices().add(notice2);
        administrator1.getNotices().add(notice3);

        contestRepository.save(contest1);
        contestRepository.save(contest2);
        contestRepository.save(contest3);

        administratorRepository.save(administrator1);

        System.out.println(administrator1.getNotices().size());



        return "initsuccess";


    }
}
