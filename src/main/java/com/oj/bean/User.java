package com.oj.bean;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int u_id;
    @Column
    private String u_nickname;
    @Column
    private String u_password;
    @Column
    private String u_mail;
    @Column
    private String u_phone;
    @Column
    private String u_sex;
    @Column
    private short u_identity;
    @Column
    private int u_all_submit;
    @Column
    private int u_all_pass;
    @Column
    private double u_pass_rate;
}
