package com.oj.bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Entity
@Table(name = "user_contest", schema = "db_oj", catalog = "")
public class UserContest {
    private Integer ucId;
    private Integer ucPassCount;//用户在比赛中的通过题目数量
    private Integer ucPosition;//用户排名
    private Time ucTime;//用户在比赛中总的做题时间，算上罚时
    private OrdinaryUser uId;
    private Contest cId;

    //用户比赛题目情况
    private List<UserContestSubject> userContestSubjects=new ArrayList<UserContestSubject>();
}
