package com.oj.bean;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Entity
@Table(name = "contest", schema = "db_oj", catalog = "")
public class Contest {
    private int cId;
    private String cName;
    private String cPlace;
    private String cContent;
    private Integer cCount;
    private String cTimeLimit;
    private Integer cUserCount;
    private Byte cIsPublic;

    @Id
    @Column(name = "c_ID")
    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Basic
    @Column(name = "c_name")
    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Basic
    @Column(name = "c_place")
    public String getcPlace() {
        return cPlace;
    }

    public void setcPlace(String cPlace) {
        this.cPlace = cPlace;
    }

    @Basic
    @Column(name = "c_content")
    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    @Basic
    @Column(name = "c_count")
    public Integer getcCount() {
        return cCount;
    }

    public void setcCount(Integer cCount) {
        this.cCount = cCount;
    }

    @Basic
    @Column(name = "c_time_limit")
    public String getcTimeLimit() {
        return cTimeLimit;
    }

    public void setcTimeLimit(String cTimeLimit) {
        this.cTimeLimit = cTimeLimit;
    }

    @Basic
    @Column(name = "c_user_count")
    public Integer getcUserCount() {
        return cUserCount;
    }

    public void setcUserCount(Integer cUserCount) {
        this.cUserCount = cUserCount;
    }

    @Basic
    @Column(name = "c_isPublic")
    public Byte getcIsPublic() {
        return cIsPublic;
    }

    public void setcIsPublic(Byte cIsPublic) {
        this.cIsPublic = cIsPublic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contest that = (Contest) o;
        return cId == that.cId &&
                Objects.equals(cName, that.cName) &&
                Objects.equals(cPlace, that.cPlace) &&
                Objects.equals(cContent, that.cContent) &&
                Objects.equals(cCount, that.cCount) &&
                Objects.equals(cTimeLimit, that.cTimeLimit) &&
                Objects.equals(cUserCount, that.cUserCount) &&
                Objects.equals(cIsPublic, that.cIsPublic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cId, cName, cPlace, cContent, cCount, cTimeLimit, cUserCount, cIsPublic);
    }
}
