package com.oj.dao;

import com.oj.bean.UserContestSubject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author TMXIAOPAI
 * @date 2019/11/18 - 21:41
 * @package_name com.oj.dao
 */
public interface UserContestSubmitRepository extends JpaRepository<UserContestSubject,Integer> {
}
