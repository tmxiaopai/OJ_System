package com.oj.dao;

import com.oj.bean.OrdinaryUser;
import com.oj.bean.SubjectSubmit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author TMXIAOPAI
 * @date 2019/11/18 - 21:38
 * @package_name com.oj.dao
 */
public interface SubjectSubmitRepository extends JpaRepository<SubjectSubmit,Integer> {

    @Query("from SubjectSubmit where ouId = :ouid")
    public List<SubjectSubmit> findByOUID(OrdinaryUser ouid);

    @Query("from SubjectSubmit where ssResult = '运行成功'")
    public List<SubjectSubmit> countPass();
}
