package com.oj.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Entity
@Table(name = "notice", schema = "db_oj", catalog = "")
@Getter
@Setter
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nId;//公告ID
    @Column
    private Timestamp nTime;//发布时间
    @Column
    private String nContent;//公告内容
    @ManyToOne
    @JoinColumn(name = "adId")
    private Administrator adId;//公告发布人

    public Notice() {

    }

    public Notice(Timestamp nTime, String nContent, Administrator adId) {
        this.nTime = nTime;
        this.nContent = nContent;
        this.adId = adId;
    }
}
