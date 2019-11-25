package com.oj.dao;

import com.oj.bean.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author TMXIAOPAI
 * @date 2019/11/18 - 21:26
 * @package_name com.oj.dao
 */
public interface AdministratorRepository extends JpaRepository<Administrator,Integer> {
    @Query(value = "from Administrator where u_id = :uid")
    public Administrator findbyuidtt(int uid);
}
