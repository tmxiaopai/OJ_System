package com.oj.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Entity
@Table(name = "contest_subject", schema = "db_oj", catalog = "")
public class ContestSubject {
    private Integer csId;//比赛题目ID
    private Integer csAllSubmit;//比赛题目总提交数
    private Integer csAllPass;//比赛题目通过次数
    private Integer csPassRate;//比赛题目通过率
    private Contest cId;//比赛ID
    private Subject sId;//题目ID 
}
