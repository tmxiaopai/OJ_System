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
@Table(name = "user_contest_subject", schema = "db_oj", catalog = "")
public class UserContestSubject {
    private int ucsId;
    private Integer errorCount;
    private Time finishTime;

    @Id
    @Column(name = "ucs_ID")
    public int getUcsId() {
        return ucsId;
    }

    public void setUcsId(int ucsId) {
        this.ucsId = ucsId;
    }

    @Basic
    @Column(name = "error_count")
    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    @Basic
    @Column(name = "finish_time")
    public Time getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Time finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserContestSubject that = (UserContestSubject) o;
        return ucsId == that.ucsId &&
                Objects.equals(errorCount, that.errorCount) &&
                Objects.equals(finishTime, that.finishTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ucsId, errorCount, finishTime);
    }
}
