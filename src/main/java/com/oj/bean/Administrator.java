package com.oj.bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Entity
@Table(name = "administrator",schema = "db_oj")
public class Administrator {
    private Integer adId;//管理员ID
    private User uId;//用户ID

    private List<Notice> notices=new ArrayList<Notice>();//管理员发布公告列表
    private List<Contest> contests=new ArrayList<Contest>();//管理员发布比赛列表
}
