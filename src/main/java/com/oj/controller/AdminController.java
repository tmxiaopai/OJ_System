package com.oj.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oj.bean.*;
import com.oj.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class AdminController {
    @Autowired
    NoticeRepository noticeRepository;
    @Autowired
    AdministratorRepository administratorRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    ContestRepository contestRepository;
    @Autowired
    OrdinaryUserRepository ordinaryUserRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ContestSubjectRepository contestSubjectRepository;
    /* 页面之间的跳转部分 */
    @RequestMapping("/home")
    public String home(){
        return "Admin/Home/home";
    }
    @RequestMapping("/tt_home_menu")
    public String homemenu(){
        return "Admin/Home/home_menu";
    }
    @RequestMapping("tt_subject_menu")
    public String ttsubjectmenu(){
        return "Admin/Subject/subject_menu";
    }
    @RequestMapping("/tt_contest_menu")
    public String contestmenu(){
        return "Admin/Contest/contest_menu";
    }
    @RequestMapping("/tt_notice_menu")
    public String noticemenu(){
        return "Admin/Notice/notice_menu";
    }
    @RequestMapping("/tt_user_menu")
    public String usermenu(){
        return "Admin/User/user_menu";
    }
    @RequestMapping("/home_notice")
    public String homenotice(){
        return "Admin/Home/notice";
    }
    @RequestMapping("/home_faq")
    public String homefaq(){
        return "Admin/Home/faq";
    }
    @RequestMapping("/tt_subject_list")
    public String subjectlist(){
        return "Admin/Subject/subject_list";
    }
    @RequestMapping("/subject_create")
    public String subject_create(){
        return "Admin/Subject/subject_create";
    }
    @RequestMapping("/tt_contest_list")
    public String contestlist(){
        return "Admin/Contest/contest_list";
    }
    @RequestMapping("/tt_contest_create")
    public String contestcreate(){
        return "Admin/Contest/contest_create";
    }
    @RequestMapping("/tt_notice_list")
    public String noticelist(){
        return "Admin/Notice/notice_list";
    }
    @RequestMapping("/tt_notice_create")
    public String noticecreate(Notice notice,Model model){
        model.addAttribute("notify_msg","");
        return "Admin/Notice/notice_create";
    }
    @RequestMapping("/tt_user_list")
    public String userlist(){
        return "Admin/User/user_list";
    }
    @RequestMapping("/tt_user")
    public String user(){
        return "Admin/User/user";
    }
    @RequestMapping("/tt_user_info")
    public String userinfo(HttpServletRequest request,Model model){
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "Admin/User/user_info";
    }
    @RequestMapping("/tt_history_submit")
    public String historysubmit(){
        return "Admin/User/history_submit";
    }
    @RequestMapping("/tt_modify_password")
    public String modifypassword(HttpServletRequest request,Model model){
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "Admin/User/modify_password";
    }
    /* ----------------------- */
    /* 题目模块 */
    private String ListSubject(List<Subject> subjects){
        JSONObject json = new JSONObject();
        JSONArray data = new JSONArray();
        for(Subject subject:subjects){
            JSONObject jo = new JSONObject();
            jo.put("sId",subject.getSId());
            jo.put("sNum",subject.getSNum());
            jo.put("sName",subject.getSName());
            jo.put("sAllSubmit",subject.getSAllSubmit());
            jo.put("sAllPass",subject.getSAllPass());
            jo.put("passRate",subject.getPassRate());
            jo.put("sSource",subject.getSSource());
            jo.put("memoryLimit",subject.getMemoryLimit());
            jo.put("timeLimit", subject.getTimeLimit());
            data.add(jo);
        }
        json.put("code",0);
        json.put("msg","");
        json.put("data",data);
        return json.toJSONString();
    }
    @RequestMapping(value = {"findallsubject"},method = RequestMethod.POST)
    @ResponseBody
    public String subjectList(String data){
        List<Subject> subjects = null;
        Subject subject=JSONObject.parseObject(data,Subject.class);
        if(subject==null){
            subjects = subjectRepository.findAll();
        }else{
            System.out.println(subject.getSNum());
            System.out.println(subject.getSName());
            subjects = subjectRepository.findbySumorSname(subject.getSName());
        }
        return ListSubject(subjects);
    }
    //创建题目
    @RequestMapping(value = {"createsubject"},method = RequestMethod.POST)
    public String createsubject(Subject subject,Model model,HttpServletRequest request){
        JSONObject json = new JSONObject();
        Integer snum = subject.getSNum();
        User user= (User) request.getSession().getAttribute("user");
        System.out.println(snum);
        if(subjectRepository.findbysnumtt(snum)==null){
            subject.setPassRate(0.0);
            subject.setSAllSubmit(0);
            subject.setSAllPass(0);
            subject.setSSource(user.getUNickname());
            subjectRepository.save(subject);
            model.addAttribute("notify_msg","创建成功");
//            json.put("code",0);
//            json.put("msg","添加成功");
        }else{
            model.addAttribute("notify_msg","创建失败");
        }
        return "Admin/Subject/subject_create";
    }
    //修改题目
    @RequestMapping(value = {"modifysubject"},method = RequestMethod.POST)
    @ResponseBody
    public String modifysubject(Subject subject){
        JSONObject json = new JSONObject();
        Subject subject1 = subjectRepository.getOne(subject.getSId());
        subject1.setMemoryLimit(subject.getMemoryLimit());
        subject1.setSName(subject.getSName());
        subject1.setTimeLimit(subject.getTimeLimit());
        subjectRepository.save(subject1);
        json.put("code",0);
        json.put("msg","修改成功");
        return json.toJSONString();
    }
    //删除题目
    @RequestMapping(value = {"deletesubject"},method = RequestMethod.POST)
    @ResponseBody
    public String deleteSubject(Integer id){
        JSONObject json = new JSONObject();
        Subject subject = subjectRepository.findbysnumtt(id);
        int sid = subject.getSId();
        System.out.println(sid);
        if(contestSubjectRepository.getbysidtt(sid)==null){
            subjectRepository.deletebynum(id);
            json.put("code",0);
            json.put("msg","删除成功");
       }else{
            contestSubjectRepository.deletebysidtt(sid);
            subjectRepository.deletebynum(id);
            json.put("code",0);
            json.put("msg","删除成功");
        }
        return json.toJSONString();
    }
    //题目加入比赛
    @RequestMapping(value = {"add_subject_to_contest"},method = RequestMethod.POST)
    @ResponseBody
    public String addsubjecttocontest(ContestSubject contestSubject){
        JSONObject json = new JSONObject();
        if(contestSubject.getCId()==null){
            json.put("code",-1);
            json.put("msg","未找到该比赛，请重新输入");
            return json.toJSONString();
        }else{
            Contest contest = contestSubject.getCId();
            Subject subject = contestSubject.getSId();
            System.out.println(contest.getCId());
            System.out.println(subject.getSId());
            System.out.println(contestSubjectRepository.subjectcount(contest.getCId()));
            int nowcount = contestSubjectRepository.subjectcount(contest.getCId());
            int sid = subject.getSId();
            int cid = contest.getCId();
            if(contestSubjectRepository.getbytt(sid,cid)==null){
                if(nowcount<contest.getCCount()){
                    contestSubjectRepository.save(contestSubject);
                    json.put("code",0);
                    json.put("msg","添加成功");
                }else{
                    json.put("code",-3);
                    json.put("msg","该比赛题目已满");
                }

            }else{
                json.put("code",-2);
                json.put("msg","该题目已在此比赛中");
            }
            return json.toJSONString();
        }
    }

    /* 比赛模块 */
    private String ListContest(List<Contest> contests){
        JSONObject json = new JSONObject();
        JSONArray data = new JSONArray();
        for(Contest contest:contests){
            JSONObject jo = new JSONObject();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            jo.put("cId",contest.getCId());
            jo.put("cName",contest.getCName());
            jo.put("cCount",contest.getCCount());
            jo.put("startTime",date.format(contest.getStartTime()));
            jo.put("endTime",date.format(contest.getEndTime()));
            jo.put("cUserCount",contest.getCUserCount());
            jo.put("cPassword",contest.getCPassword());
            jo.put("isFinish",contest.getIsFinish());
            data.add(jo);
        }
        json.put("code",0);
        json.put("msg","");
        json.put("data",data);
        return json.toJSONString();
    }
    @RequestMapping(value = {"findallcontest"},method = RequestMethod.POST)
    @ResponseBody
    public String contestList(String data){
        List<Contest> contests = null;
        Contest contest = JSONObject.parseObject(data,Contest.class);
        if (contest==null){
            contests = contestRepository.findAll();
        }else {
            contests = contestRepository.findbynamett(contest.getCName());
        }

        return ListContest(contests);
    }
    //创建比赛
    @RequestMapping(value = {"createContest"},method = RequestMethod.POST)
    public String createContest(Contest contest,HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        Administrator administrator = administratorRepository.findbyuidtt(user.getUId());
        contest.setCreateUserId(administrator);
        contest.setIsFinish(Short.valueOf("0"));
        contest.setCUserCount(0);
        contestRepository.save(contest);
        return "Admin/Contest/contest_create";
    }

    /* 公告模块*/
    //公告查询
    private String ListNotice(List<Notice> notices){
        JSONObject json = new JSONObject();
        JSONArray data =  new JSONArray();
        for(Notice notice:notices){
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            JSONObject jo = new JSONObject();
            jo.put("nId",notice.getNId());
            jo.put("nName",notice.getNName());
            jo.put("nContent",notice.getNContent());
            jo.put("nTime",date.format(notice.getNTime()));
            data.add(jo);
        }
        json.put("code",0);
        json.put("msg","添加成功");
        json.put("data",data);
        return json.toJSONString();
    }
    @RequestMapping(value={"findallnotice"},method = RequestMethod.POST)
    @ResponseBody
    public String noticeList(String data){
        List<Notice> notices = null;
        Notice notice = JSONObject.parseObject(data,Notice.class);
        if(notice==null){
            notices = noticeRepository.findAll();
        }else{
            notices = noticeRepository.findbynamett(notice.getNName());
        }
        return ListNotice(notices);
    }
    //添加公告
    @RequestMapping(value={"add_notice"},method = RequestMethod.POST)
    public String addnotice(Notice notice, Model model,HttpServletRequest request){
        model.addAttribute("notify_msg","添加成功");
        Date date = new Date();
        User user= (User) request.getSession().getAttribute("user");
        Administrator administrator = administratorRepository.findbyuidtt(user.getUId());
        notice.setAdId(administrator);
        notice.setNContent(notice.getNContent());
        notice.setNTime(date);
        noticeRepository.save(notice);
        System.out.println(notice.getNContent());
        return "Admin/Notice/notice_create";
    }
    //删除
    @RequestMapping(value = {"deletenotice"},method = RequestMethod.POST)
    @ResponseBody
    public String deletenotice(Integer id){
        JSONObject json = new JSONObject();
        noticeRepository.deletenoticeid(id);
        json.put("code",0);
        json.put("msg","删除成功");
        return json.toJSONString();
    }
    //修改
    @RequestMapping(value = {"modifynotice"},method = RequestMethod.POST)
    @ResponseBody
    public String modifynotice(Notice notice){
        JSONObject json = new JSONObject();
        Notice notice1 = noticeRepository.getOne(notice.getNId());
        notice1.setNName(notice.getNName());
        notice1.setNContent(notice.getNContent());
        noticeRepository.save(notice1);
        json.put("code",0);
        json.put("msg","修改成功");
        return json.toJSONString();
    }
    /* 用户模块 */
    private String ListUser(List<User> users){
        JSONObject json = new JSONObject();
        JSONArray data = new JSONArray();
        for(User user:users){
            if(user.getUIdentity()==1)
                continue;
            JSONObject jo = new JSONObject();
            jo.put("uId",user.getUId());
            jo.put("uNickname",user.getUNickname());
            jo.put("uMail",user.getUMail());
            jo.put("uPhone",user.getUPhone());
            jo.put("uSex",user.getUSex());
            data.add(jo);
        }
        json.put("code",0);
        json.put("msg","");
        json.put("data",data);
        return json.toJSONString();
    }
    @RequestMapping(value = {"findalluser"},method = RequestMethod.POST)
    @ResponseBody
    public String userList(String data){
        List<User> users = null;
        User user = JSONObject.parseObject(data,User.class);
        if(user==null){
            users = userRepository.findAll();
        }else{
            users = userRepository.finduserbynick(user.getUNickname());
        }
        return ListUser(users);
    }
    //权限啊
    @RequestMapping(value = {"modifypower"},method = RequestMethod.POST)
    @ResponseBody
    public String modifypower(User user){
        JSONObject json = new JSONObject();
        System.out.println(user.getUNickname());
        User user1 = userRepository.getOne(user.getUId());
        user1.setUIdentity(Short.parseShort("1"));
        userRepository.save(user1);
        json.put("code",0);
        json.put("msg","修改成功");
        return json.toJSONString();
    }
    //读取个人信息
    @RequestMapping(value = {"userinfo"},method = RequestMethod.POST)
    @ResponseBody
    public String UserInfo(){
        User user = userRepository.getOne(1);
        JSONObject json = new JSONObject();
        json.put("uIdentity",user.getUIdentity());
        json.put("uId",user.getUIdentity());
        json.put("uNickname",user.getUNickname());
        json.put("uSex",user.getUSex());
        json.put("uPhone",user.getUPhone());
        json.put("uMail",user.getUMail());
        return json.toJSONString();
    }
    //修改密码
    @RequestMapping(value = {"modifypassword"},method = RequestMethod.POST)
    public String modifypassword(User user){
        User finduser = userRepository.getOne(user.getUId());
        finduser.setUPassword(user.getUPassword());
        userRepository.save(finduser);
        return "Admin/User/modify_password";
    }
    //修改个人信息
    @RequestMapping(value = {"modifyuserinfo"},method = RequestMethod.POST)
    public String modifyuserinfo(User user){
        User finduser=userRepository.getOne(user.getUId());
        finduser.setUNickname(user.getUNickname());
        finduser.setUPhone(user.getUPhone());
        finduser.setUSex(user.getUSex());
        userRepository.save(finduser);
        return "Admin/User/user_info";
    }
}
