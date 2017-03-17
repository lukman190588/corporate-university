package com.id.corpu.backend.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.id.corpu.backend.dao.TblEventDao;
import com.id.corpu.backend.entity.TblEvent;

@Transactional
@RestController
public class EventController {

	@Autowired
	TblEventDao eventDao;

	@PostMapping("/event/save/")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveEvent(@RequestBody @Valid TblEvent event) {
		eventDao.save(event);
	}
}
