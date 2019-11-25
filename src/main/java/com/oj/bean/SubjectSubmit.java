package com.oj.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Getter
@Setter
@Entity
@Table(name = "subject_submit", schema = "db_oj", catalog = "")
public class SubjectSubmit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ssId;//题目提交记录ID
    @Column
    private String ssResult;//题目运行结果
    @Column
    private long ssRuntime;//题目运行时间
    @Column
    private Integer ssMemorySize;//题目内存占用
    @Column
    private String ssLanguage;//答题语言
    @Column
    private String ssCompileInfo;//
    @Column
    private Integer ssCodeLength;//代码长度
    @Column
    private Date ssTime;
    @ManyToOne
    @JoinColumn(name = "ouId")
    private OrdinaryUser ouId;
    @ManyToOne
    @JoinColumn(name = "sId")
    private Subject sId;

    public SubjectSubmit() {
    }

    public SubjectSubmit(String ssResult, long ssRuntime, Integer ssMemorySize, String ssLanguage, String ssCompileInfo, Integer ssCodeLength, Date ssTime, OrdinaryUser ouId, Subject sId) {
        this.ssResult = ssResult;
        this.ssRuntime = ssRuntime;
        this.ssMemorySize = ssMemorySize;
        this.ssLanguage = ssLanguage;
        this.ssCompileInfo = ssCompileInfo;
        this.ssCodeLength = ssCodeLength;
        this.ssTime = ssTime;
        this.ouId = ouId;
        this.sId = sId;
    }
}
