package com.oj.dao;

import com.oj.bean.Contest;
import com.oj.bean.ContestSubject;
import com.oj.bean.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author TMXIAOPAI
 * @date 2019/11/18 - 21:36
 * @package_name com.oj.dao
 */
public interface ContestSubjectRepository extends JpaRepository<ContestSubject,Integer> {
    @Query("from ContestSubject where s_id = :sid and c_id = :cid")
    public ContestSubject getbytt(int sid, int cid);

    @Query("from ContestSubject where s_id = :sid")
    public List<ContestSubject> getbysidtt(int sid);

    @Modifying
    @Transactional
    @Query(value = "delete from contest_subject where s_id=?1",nativeQuery = true)
    public void deletebysidtt(int sid);

    @Query(value = "select count(*) from contest_subject where c_id=?1",nativeQuery = true)
    public int subjectcount(int cid);
}
