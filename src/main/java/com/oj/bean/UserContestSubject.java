package com.oj.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Getter
@Setter
@Entity
@Table(name = "user_contest_subject", schema = "db_oj", catalog = "")
public class UserContestSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ucsId;//用户比赛题目ID
    @Column
    private Integer errorCount;//错误提交次数
    @Column
    private Timestamp finishTime;//完成总时间
    @ManyToOne
    @JoinColumn(name = "ucId")
    private UserContest ucId;//用户比赛ID

    public UserContestSubject() {
    }

    public UserContestSubject(Integer errorCount, Timestamp finishTime, UserContest ucId) {
        this.errorCount = errorCount;
        this.finishTime = finishTime;
        this.ucId = ucId;
    }
}
