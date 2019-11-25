package com.oj.dao;

import com.oj.bean.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author TMXIAOPAI
 * @date 2019/11/18 - 21:37
 * @package_name com.oj.dao
 */
public interface NoticeRepository extends JpaRepository<Notice,Integer> {
    @Query(value = "select n from Notice n where n.nName like %?1% ")
    List<Notice> findbynamett(String nname);

    @Modifying
    @Transactional
    @Query(value = "delete  from Notice n where n.nId=?1 ")
    void deletenoticeid(int id);
}
