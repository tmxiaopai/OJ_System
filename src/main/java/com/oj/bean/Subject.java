package com.oj.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject", schema = "db_oj", catalog = "")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sId;//题ID
    @Column
    private Integer sNum;//题号
    @Column(length = 20)
    private String sName;//题名
    @Column
    private Integer sAllSubmit;//总提交数
    @Column
    private Integer sAllPass;//总通过数
    @Column(length = 10)
    private String sType;//题目类型
    @Column
    private short sDegree;//题目难度0 1 2 简单 中等 难
    @Column(length = 10)
    private String sSource;//题目贡献者

    private List<SubjectSubmit> subjectSubmits=new ArrayList<SubjectSubmit>();//题目提交情况
}
