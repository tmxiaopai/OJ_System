package com.oj.dao;

import com.oj.bean.OrdinaryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author TMXIAOPAI
 * @date 2019/11/18 - 21:12
 * @package_name com.oj.dao
 */
public interface OrdinaryUserRepository extends JpaRepository<OrdinaryUser,Integer> {
    @Query("From OrdinaryUser order by ouAllPass desc")
    public List<OrdinaryUser> rankListByPassCount();

}
