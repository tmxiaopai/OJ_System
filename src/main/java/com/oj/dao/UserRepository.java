package com.oj.dao;

import com.oj.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>{
    @Query("from User where uMail = :email")
    public List<User> findByEmail(String email);

    @Query(value = "select u from  User u where u.uNickname like %?1% ")
    public List<User> finduserbynick(String nickname);
}
