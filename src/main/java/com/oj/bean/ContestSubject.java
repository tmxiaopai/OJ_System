package com.oj.bean;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Entity
@Table(name = "contest_subject", schema = "db_oj", catalog = "")
public class ContestSubject {
    private int csId;
    private Integer csAllSubmit;
    private Integer csAllPass;
    private Integer csPassRate;

    @Id
    @Column(name = "cs_ID")
    public int getCsId() {
        return csId;
    }

    public void setCsId(int csId) {
        this.csId = csId;
    }

    @Basic
    @Column(name = "cs_all_submit")
    public Integer getCsAllSubmit() {
        return csAllSubmit;
    }

    public void setCsAllSubmit(Integer csAllSubmit) {
        this.csAllSubmit = csAllSubmit;
    }

    @Basic
    @Column(name = "cs_all_pass")
    public Integer getCsAllPass() {
        return csAllPass;
    }

    public void setCsAllPass(Integer csAllPass) {
        this.csAllPass = csAllPass;
    }

    @Basic
    @Column(name = "cs_pass_rate")
    public Integer getCsPassRate() {
        return csPassRate;
    }

    public void setCsPassRate(Integer csPassRate) {
        this.csPassRate = csPassRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContestSubject that = (ContestSubject) o;
        return csId == that.csId &&
                Objects.equals(csAllSubmit, that.csAllSubmit) &&
                Objects.equals(csAllPass, that.csAllPass) &&
                Objects.equals(csPassRate, that.csPassRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(csId, csAllSubmit, csAllPass, csPassRate);
    }
}
