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
@Table(name = "notice", schema = "db_oj", catalog = "")
public class Notice {
    private int nId;//公告ID
    private Timestamp nTime;//发布时间
    private String nContent;//公告内容
    private Administrator adId;//公告发布人
}
