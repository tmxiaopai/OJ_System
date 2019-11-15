package com.oj.bean;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Entity
@Table(name = "user", schema = "db_oj")
public class User {
    private int uId;
    private String uNickname;
    private String uPassword;
    private Integer uAllPass;
    private Integer uAllSubmit;
    private Short uIdentity;
    private String uMail;
    private Double uPassRate;
    private String uPhone;
    private String uSex;

    @Id
    @Column(name = "u_id")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "u_nickname")
    public String getuNickname() {
        return uNickname;
    }

    public void setuNickname(String uNickname) {
        this.uNickname = uNickname;
    }

    @Basic
    @Column(name = "u_password")
    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Basic
    @Column(name = "u_all_pass")
    public Integer getuAllPass() {
        return uAllPass;
    }

    public void setuAllPass(Integer uAllPass) {
        this.uAllPass = uAllPass;
    }

    @Basic
    @Column(name = "u_all_submit")
    public Integer getuAllSubmit() {
        return uAllSubmit;
    }

    public void setuAllSubmit(Integer uAllSubmit) {
        this.uAllSubmit = uAllSubmit;
    }

    @Basic
    @Column(name = "u_identity")
    public Short getuIdentity() {
        return uIdentity;
    }

    public void setuIdentity(Short uIdentity) {
        this.uIdentity = uIdentity;
    }

    @Basic
    @Column(name = "u_mail")
    public String getuMail() {
        return uMail;
    }

    public void setuMail(String uMail) {
        this.uMail = uMail;
    }

    @Basic
    @Column(name = "u_pass_rate")
    public Double getuPassRate() {
        return uPassRate;
    }

    public void setuPassRate(Double uPassRate) {
        this.uPassRate = uPassRate;
    }

    @Basic
    @Column(name = "u_phone")
    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    @Basic
    @Column(name = "u_sex")
    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return uId == that.uId &&
                Objects.equals(uNickname, that.uNickname) &&
                Objects.equals(uPassword, that.uPassword) &&
                Objects.equals(uAllPass, that.uAllPass) &&
                Objects.equals(uAllSubmit, that.uAllSubmit) &&
                Objects.equals(uIdentity, that.uIdentity) &&
                Objects.equals(uMail, that.uMail) &&
                Objects.equals(uPassRate, that.uPassRate) &&
                Objects.equals(uPhone, that.uPhone) &&
                Objects.equals(uSex, that.uSex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, uNickname, uPassword, uAllPass, uAllSubmit, uIdentity, uMail, uPassRate, uPhone, uSex);
    }
}
