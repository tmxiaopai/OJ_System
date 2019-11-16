package com.oj.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Getter
@Setter
@Entity
@Table(name = "contest_subject", schema = "db_oj", catalog = "")
public class ContestSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer csId;//比赛题目ID
    @Column
    private Integer csAllSubmit;//比赛题目总提交数
    @Column
    private Integer csAllPass;//比赛题目通过次数
    @Column
    private Integer csPassRate;//比赛题目通过率
    @ManyToOne
    @JoinColumn(name = "cId")
    private Contest cId;//比赛ID
    @ManyToOne
    @JoinColumn(name = "sId")
    private Subject sId;//题目ID

    public ContestSubject() {
    }
}
