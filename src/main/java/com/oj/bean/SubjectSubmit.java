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
@Table(name = "subject_submit", schema = "db_oj", catalog = "")
public class SubjectSubmit {
    private int ssId;
    private String ssResult;
    private Timestamp ssRuntime;
    private Integer ssMemorySize;
    private String ssLanguage;
    private String ssCompileInfo;
    private Integer ssCodeLength;
    private Timestamp ssTime;

    @Id
    @Column(name = "ss_ID")
    public int getSsId() {
        return ssId;
    }

    public void setSsId(int ssId) {
        this.ssId = ssId;
    }

    @Basic
    @Column(name = "ss_result")
    public String getSsResult() {
        return ssResult;
    }

    public void setSsResult(String ssResult) {
        this.ssResult = ssResult;
    }

    @Basic
    @Column(name = "ss_runtime")
    public Timestamp getSsRuntime() {
        return ssRuntime;
    }

    public void setSsRuntime(Timestamp ssRuntime) {
        this.ssRuntime = ssRuntime;
    }

    @Basic
    @Column(name = "ss_memory_size")
    public Integer getSsMemorySize() {
        return ssMemorySize;
    }

    public void setSsMemorySize(Integer ssMemorySize) {
        this.ssMemorySize = ssMemorySize;
    }

    @Basic
    @Column(name = "ss_language")
    public String getSsLanguage() {
        return ssLanguage;
    }

    public void setSsLanguage(String ssLanguage) {
        this.ssLanguage = ssLanguage;
    }

    @Basic
    @Column(name = "ss_compile_info")
    public String getSsCompileInfo() {
        return ssCompileInfo;
    }

    public void setSsCompileInfo(String ssCompileInfo) {
        this.ssCompileInfo = ssCompileInfo;
    }

    @Basic
    @Column(name = "ss_code_length")
    public Integer getSsCodeLength() {
        return ssCodeLength;
    }

    public void setSsCodeLength(Integer ssCodeLength) {
        this.ssCodeLength = ssCodeLength;
    }

    @Basic
    @Column(name = "ss_time")
    public Timestamp getSsTime() {
        return ssTime;
    }

    public void setSsTime(Timestamp ssTime) {
        this.ssTime = ssTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectSubmit that = (SubjectSubmit) o;
        return ssId == that.ssId &&
                Objects.equals(ssResult, that.ssResult) &&
                Objects.equals(ssRuntime, that.ssRuntime) &&
                Objects.equals(ssMemorySize, that.ssMemorySize) &&
                Objects.equals(ssLanguage, that.ssLanguage) &&
                Objects.equals(ssCompileInfo, that.ssCompileInfo) &&
                Objects.equals(ssCodeLength, that.ssCodeLength) &&
                Objects.equals(ssTime, that.ssTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssId, ssResult, ssRuntime, ssMemorySize, ssLanguage, ssCompileInfo, ssCodeLength, ssTime);
    }
}
