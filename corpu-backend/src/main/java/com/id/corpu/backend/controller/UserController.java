package com.id.corpu.backend.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.id.corpu.backend.dao.UserDao;
import com.id.corpu.backend.dao.UserResponse;
import com.id.corpu.backend.entity.TblUser;

@RestController
public class UserController {

	@Autowired
	UserDao userDao;

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/api/user/me")
	@ResponseBody
	public Authentication currentUser(Authentication auth) {
		return auth;
	}

	@RequestMapping("/login")
	public void loginPage() {
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/home")
	public ModelMap homepage(Authentication currentUser) {
		return new ModelMap("user", currentUser);
	}

	@RequestMapping("/api/user/getAllUser")
	public List<UserResponse> getAllUser() {
		List<UserResponse> listUser = new ArrayList<UserResponse>();
		listUser.clear();
		for (TblUser user : userDao.findAll()) {
			UserResponse response = new UserResponse();
			response.setId(user.getId());
			response.setUsername(user.getUsername());
			response.setFullname(user.getFullname());
			listUser.add(response);
		}
		return listUser;
	}

	@PostMapping("/api/user/saveUser")
	@ResponseStatus(HttpStatus.CREATED)
	public void savePenjualan(@RequestBody @Valid UserResponse newUser) {
		TblUser userLast = userDao.findTop1ByOrderByIdDesc();
		int passInt = Integer.parseInt(userLast.getId().substring(1)) + 1;
		String newId = String.format("%04d", passInt);
		TblUser user = new TblUser();
		user.setId("u"+ newId);
		user.setUsername(newUser.getUsername().replace(" ", ""));
		user.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
		user.setFullname(newUser.getFullname());
		user.setActive(1);
		userDao.save(user);
	}
}