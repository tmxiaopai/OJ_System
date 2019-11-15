package com.oj.bean;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Entity
@Table(name = "user_contest", schema = "db_oj", catalog = "")
public class UserContest {
    private int ucId;
    private Integer ucPassCount;
    private Integer ucPosition;
    private Time ucTime;

    @Id
    @Column(name = "uc_ID")
    public int getUcId() {
        return ucId;
    }

    public void setUcId(int ucId) {
        this.ucId = ucId;
    }

    @Basic
    @Column(name = "uc_pass_count")
    public Integer getUcPassCount() {
        return ucPassCount;
    }

    public void setUcPassCount(Integer ucPassCount) {
        this.ucPassCount = ucPassCount;
    }

    @Basic
    @Column(name = "uc_position")
    public Integer getUcPosition() {
        return ucPosition;
    }

    public void setUcPosition(Integer ucPosition) {
        this.ucPosition = ucPosition;
    }

    @Basic
    @Column(name = "uc_time")
    public Time getUcTime() {
        return ucTime;
    }

    public void setUcTime(Time ucTime) {
        this.ucTime = ucTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserContest that = (UserContest) o;
        return ucId == that.ucId &&
                Objects.equals(ucPassCount, that.ucPassCount) &&
                Objects.equals(ucPosition, that.ucPosition) &&
                Objects.equals(ucTime, that.ucTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ucId, ucPassCount, ucPosition, ucTime);
    }
}
