package com.oj.dao;

import com.oj.bean.OrdinaryUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author TMXIAOPAI
 * @date 2019/11/18 - 21:12
 * @package_name com.oj.dao
 */
public interface OrdinaryUserRepository extends JpaRepository<OrdinaryUser,Integer> {
}
