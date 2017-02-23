package com.diklatproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diklatproject.entity.TblUser;

public interface TblUserDao extends JpaRepository<TblUser, String>{

	List<TblUser> findAllUsers();
}
