package com.oj.bean;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Entity
@Table(name = "subject", schema = "db_oj", catalog = "")
public class Subject {
    private Integer sNum;
    private String sName;
    private int sId;
    private Integer sAllSubmit;
    private Integer sAllPass;
    private String sType;
    private Short sDegree;
    private String sSource;

    @Basic
    @Column(name = "s_num")
    public Integer getsNum() {
        return sNum;
    }

    public void setsNum(Integer sNum) {
        this.sNum = sNum;
    }

    @Basic
    @Column(name = "s_name")
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Id
    @Column(name = "s_ID")
    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    @Basic
    @Column(name = "s_all_submit")
    public Integer getsAllSubmit() {
        return sAllSubmit;
    }

    public void setsAllSubmit(Integer sAllSubmit) {
        this.sAllSubmit = sAllSubmit;
    }

    @Basic
    @Column(name = "s_all_pass")
    public Integer getsAllPass() {
        return sAllPass;
    }

    public void setsAllPass(Integer sAllPass) {
        this.sAllPass = sAllPass;
    }

    @Basic
    @Column(name = "s_type")
    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    @Basic
    @Column(name = "s_degree")
    public Short getsDegree() {
        return sDegree;
    }

    public void setsDegree(Short sDegree) {
        this.sDegree = sDegree;
    }

    @Basic
    @Column(name = "s_source")
    public String getsSource() {
        return sSource;
    }

    public void setsSource(String sSource) {
        this.sSource = sSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject that = (Subject) o;
        return sId == that.sId &&
                Objects.equals(sNum, that.sNum) &&
                Objects.equals(sName, that.sName) &&
                Objects.equals(sAllSubmit, that.sAllSubmit) &&
                Objects.equals(sAllPass, that.sAllPass) &&
                Objects.equals(sType, that.sType) &&
                Objects.equals(sDegree, that.sDegree) &&
                Objects.equals(sSource, that.sSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sNum, sName, sId, sAllSubmit, sAllPass, sType, sDegree, sSource);
    }
}
