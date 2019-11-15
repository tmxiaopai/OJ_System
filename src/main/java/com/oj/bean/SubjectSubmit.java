package com.oj.bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Entity
@Table(name = "subject_submit", schema = "db_oj", catalog = "")
public class SubjectSubmit {
    private Integer ssId;//题目提交记录ID
    private String ssResult;//题目运行结果
    private Timestamp ssRuntime;//题目运行时间
    private Integer ssMemorySize;//题目内存占用
    private String ssLanguage;//答题语言
    private String ssCompileInfo;//
    private Integer ssCodeLength;//代码长度
    private Timestamp ssTime;

}
