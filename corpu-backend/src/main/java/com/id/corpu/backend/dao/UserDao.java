package com.id.corpu.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.id.corpu.backend.entity.User;

public interface UserDao extends JpaRepository<User, String>{

	User findTop1ByOrderByIdDesc();
}
