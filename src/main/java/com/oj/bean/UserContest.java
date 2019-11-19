package com.oj.bean;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Getter
@Setter
@Entity
@Table(name = "user_contest", schema = "db_oj", catalog = "")
public class UserContest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ucId;
    @Column
    private Integer ucPassCount;//用户在比赛中的通过题目数量
    @Column
    private Integer ucPosition;//用户排名
    @Column
    private Timestamp ucTime;//用户在比赛中总的做题时间，算上罚时

    @ManyToOne
    @JoinColumn(name = "ouId")
    private OrdinaryUser ouId;
    @ManyToOne
    @JoinColumn(name = "cId")
    private Contest cId;

    //用户比赛题目情况
    @OneToMany(mappedBy = "ucId",cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UserContestSubject> userContestSubjects=new ArrayList<UserContestSubject>();

    public UserContest() {
    }

    public UserContest(Integer ucPassCount, Integer ucPosition, Timestamp ucTime, OrdinaryUser ouId, Contest cId) {
        this.ucPassCount = ucPassCount;
        this.ucPosition = ucPosition;
        this.ucTime = ucTime;
        this.ouId = ouId;
        this.cId = cId;
    }
}
