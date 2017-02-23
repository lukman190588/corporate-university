package com.diklatproject.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diklatproject.dao.TblUserDao;
import com.diklatproject.entity.TblUser;

@Transactional
@RestController
public class UserController {

	@Autowired
	TblUserDao userDao;

	@PostMapping("/user/save/")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveEvent(@RequestBody @Valid TblUser user) {
		userDao.save(user);
	}
}
