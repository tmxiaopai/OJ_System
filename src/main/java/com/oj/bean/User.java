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

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public void setU_nickname(String u_nickname) {
        this.u_nickname = u_nickname;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public int getU_id() {
        return u_id;
    }

    public String getU_nickname() {
        return u_nickname;
    }

    public String getU_password() {
        return u_password;
    }

    public User() {
    }
}
