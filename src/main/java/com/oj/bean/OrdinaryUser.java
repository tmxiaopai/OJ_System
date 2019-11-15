package com.oj.bean;

import java.util.ArrayList;
import java.util.List;

public class OrdinaryUser {
    private Integer ouId;//普通用户ID
    private Integer ouAllPass;//用户总通过题数
    private Integer ouAllSubmit;//用户总提交次数
    private Double ouPassRate;//用户题目通过率
    private User uId;//用户ID

    private List<UserContest> userContests=new ArrayList<UserContest>();//用户参加比赛列表
    private List<SubjectSubmit> subjectSubmits=new ArrayList<SubjectSubmit>();//用户的提交记录
}
