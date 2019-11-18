package com.oj.dao;

import com.oj.bean.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author TMXIAOPAI
 * @date 2019/11/18 - 21:26
 * @package_name com.oj.dao
 */
public interface AdministratorRepository extends JpaRepository<Administrator,Integer> {
}
