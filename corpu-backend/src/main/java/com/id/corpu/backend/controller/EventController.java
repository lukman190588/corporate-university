package com.id.corpu.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/api/events/getAllEventsPaged")
	public Map<String, Object> getAllEventsPaged(@RequestParam(
			value = "pageNumber", required = true) int pageN, 
			@RequestParam(value = "pageSize", required = true) int pageS) {
		Integer pageNumber = Integer.valueOf(pageN);
		Integer pageSize = Integer.valueOf(pageS);
		List<TblEvent> list = eventDao.findAll();
		
		/**
		 * cek pageSize
		 */
		if (pageSize == null || pageSize <= 0 || pageSize > list.size())
			pageSize = list.size();

		/**
		 * hitung jumlah halaman
		 */
		int numPages = (int) Math.ceil((double) list.size() / (double) pageSize);

		List<List<TblEvent>> listPaged = new ArrayList<List<TblEvent>>(numPages);
	    for (int pageNum = 0; pageNum < numPages;)
	        listPaged.add(list.subList(pageNum * pageSize, Math.min(++pageNum * pageSize, list.size())));

		TreeMap<String, Object> tResp = new TreeMap<String, Object>();
		tResp.put("items", listPaged.get(pageNumber-1));
		tResp.put("total", list.size());
		return tResp;
	}
}
