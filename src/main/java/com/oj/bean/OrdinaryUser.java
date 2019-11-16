package com.oj.bean;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "ordinary_user", schema = "db_oj", catalog = "")
public class OrdinaryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ouId;//普通用户ID
    @Column
    private Integer ouAllPass;//用户总通过题数
    @Column
    private Integer ouAllSubmit;//用户总提交次数
    @Column
    private Double ouPassRate;//用户题目通过率
    @OneToOne
    @JoinColumn(name = "uId")
    private User uId;//用户ID
    @OneToMany(mappedBy = "ouId",cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UserContest> userContests=new ArrayList<UserContest>();//用户参加比赛列表
    @OneToMany(mappedBy = "ouId",cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<SubjectSubmit> subjectSubmits=new ArrayList<SubjectSubmit>();//用户的提交记录

    public OrdinaryUser() {
    }
}
