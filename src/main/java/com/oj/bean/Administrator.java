package com.oj.bean;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TMXIAOPAI
 * @date 2019/11/15 - 9:42
 * @package_name com.oj.bean
 */
@Getter
@Setter
@Entity
@Table(name = "administrator", schema = "db_oj")
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adId;//管理员ID
    @OneToOne
    @JoinColumn(name = "uId")
    private User uId;//用户ID
    @OneToMany(mappedBy = "adId", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Notice> notices = new ArrayList<Notice>();//管理员发布公告列表
    @OneToMany(mappedBy = "createUserId", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Contest> contests = new ArrayList<Contest>();//管理员发布比赛列表

    public Administrator(User uId) {
        this.uId = uId;
    }

    public Administrator() {
    }
}
