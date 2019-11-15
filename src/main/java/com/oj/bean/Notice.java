package com.oj.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Entity
@Table(name = "notice", schema = "db_oj", catalog = "")
public class Notice {
    private int nId;
    private Timestamp nTime;
    private String nContent;

    @Id
    @Column(name = "n_ID")
    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    @Basic
    @Column(name = "n_time")
    public Timestamp getnTime() {
        return nTime;
    }

    public void setnTime(Timestamp nTime) {
        this.nTime = nTime;
    }

    @Basic
    @Column(name = "n_content")
    public String getnContent() {
        return nContent;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notice that = (Notice) o;
        return nId == that.nId &&
                Objects.equals(nTime, that.nTime) &&
                Objects.equals(nContent, that.nContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nId, nTime, nContent);
    }
}
