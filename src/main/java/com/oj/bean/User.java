package com.oj.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Entity
@Table(name = "user", schema = "db_oj")
public class User {
    private Integer uId;//用户ID
    private String uNickname;
    private String uPassword;
    private short uIdentity;//0-ou,1-ad
    private String uMail;
    private String uPhone;
    private String uSex;
}
