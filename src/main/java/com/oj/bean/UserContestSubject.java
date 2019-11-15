package com.oj.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Entity
@Table(name = "user_contest_subject", schema = "db_oj", catalog = "")
public class UserContestSubject {
    private Integer ucsId;//用户比赛题目ID
    private Integer errorCount;//错误提交次数
    private String finishTime;//完成总时间
    private UserContest ucId;//用户比赛ID
}
