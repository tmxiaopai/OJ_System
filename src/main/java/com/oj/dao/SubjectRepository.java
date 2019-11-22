package com.oj.dao;

import com.oj.bean.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Integer>{
    @Query("from Subject where sName like %:name% or sNum = :snum")
    public List<Subject> findAllBysName(String name,Integer snum);


    @Query("from Subject where sDegree = :degree")
    public List<Subject> findByDegree(short degree);
}
