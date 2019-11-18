package com.oj.dao;

import com.oj.bean.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author TMXIAOPAI
 * @date 2019/11/18 - 21:37
 * @package_name com.oj.dao
 */
public interface NoticeRepository extends JpaRepository<Notice,Integer> {
}
