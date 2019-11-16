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
@Table(name = "user", schema = "db_oj")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uId;//用户ID
    @Column
    private String uNickname;
    @Column
    private String uPassword;
    @Column
    private short uIdentity;//0-ou,1-ad
    @Column
    private String uMail;
    @Column
    private String uPhone;
    @Column
    private String uSex;

    public User() {
    }
}
