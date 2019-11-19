package com.oj.bean;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Getter
@Setter
@Entity
@Table(name = "contest", schema = "db_oj", catalog = "")
public class Contest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cId;
    @Column(length = 20)
    private String cName;
    @Column(length = 20)
    private String cPlace;//比赛地点
    @Column(length = 200)
    private String cDescription;//比赛描述
    @Column
    private Integer cCount;//题目数量
    @Column
    private Date startTime;//比赛开始时间
    @Column
    private Date endTime;//比赛结束时间
    @Column
    private Integer cUserCount;//报名人数
    @Column
    private boolean cIsPublic;//是否公开
    @Column(length = 20)
    private String cPassword;//比赛密码
    @Column
    private short isFinish;//是否完成
    @ManyToOne
    @JoinColumn(name = "createUserId")
    private Administrator createUserId;//创建比赛人
    @OneToMany(mappedBy = "cId", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ContestSubject> contestSubjects = new ArrayList<ContestSubject>();//比赛题目列表
    @OneToMany(mappedBy = "cId", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UserContest> userContests = new ArrayList<UserContest>();//用户比赛表，获取用户的排名以及做题情况

    public Contest(String cName, String cPlace, String cDescription, Integer cCount, Date startTime, Date endTime, Integer cUserCount, boolean cIsPublic, String cPassword, Administrator createUserId, short isFinish) {
        this.cName = cName;
        this.cPlace = cPlace;
        this.cDescription = cDescription;
        this.cCount = cCount;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cUserCount = cUserCount;
        this.cIsPublic = cIsPublic;
        this.cPassword = cPassword;
        this.isFinish = isFinish;
        this.createUserId = createUserId;
    }

    public Contest() {
    }
}
