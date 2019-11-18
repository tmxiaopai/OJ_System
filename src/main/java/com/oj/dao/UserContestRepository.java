package com.oj.dao;

import com.oj.bean.UserContest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author TMXIAOPAI
 * @date 2019/11/18 - 21:39
 * @package_name com.oj.dao
 */
public interface UserContestRepository extends JpaRepository<UserContest,Integer> {
}
