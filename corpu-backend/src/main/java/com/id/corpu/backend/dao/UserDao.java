package com.id.corpu.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.id.corpu.backend.entity.TblUser;


public interface UserDao extends JpaRepository<TblUser, String>{

	TblUser findTop1ByOrderByIdDesc();
}
