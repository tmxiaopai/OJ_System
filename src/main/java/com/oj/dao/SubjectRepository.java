package com.oj.dao;

import com.oj.bean.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Integer>{
}
