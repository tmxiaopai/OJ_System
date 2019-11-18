package com.oj.dao;

import com.oj.bean.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author TMXIAOPAI
 * @date 2019/11/18 - 21:35
 * @package_name com.oj.dao
 */
public interface ContestRepository extends JpaRepository<Contest,Integer> {

}
