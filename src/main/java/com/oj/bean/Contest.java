package com.oj.bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Entity
@Table(name = "contest", schema = "db_oj", catalog = "")
public class Contest {
    private Integer cId;
    private String cName;
    private String cPlace;//比赛地点
    private String cDescription;//比赛描述
    private Integer cCount;//题目数量
    private String cTimeLimit;//时间限制
    private Integer cUserCount;//报名人数
    private boolean cIsPublic;//是否公开
    private String cPassword;//比赛密码

    private Administrator createUserId;//创建比赛人

    private List<ContestSubject> contestSubjects = new ArrayList<ContestSubject>();//比赛题目列表
    private List<UserContest> userContests = new ArrayList<UserContest>();//用户比赛表，获取用户的排名以及做题情况


}
