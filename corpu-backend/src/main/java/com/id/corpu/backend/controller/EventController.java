package com.id.corpu.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.log4j.Logger;
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

    private static Logger log = Logger.getLogger(EventController.class);
	
	@Autowired
	TblEventDao eventDao;

	@PostMapping("/api/event/saveEvent")
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
		TreeMap<String, Object> mappedList = getPagedMap(pageSize, pageNumber, list);
		return mappedList;
	}

	@RequestMapping("/api/events/getAllEventsBy")
	public Map<String, Object> getAllEventsBy(
			@RequestParam(value = "pageNumber", required = true) int pageN, 
			@RequestParam(value = "pageSize", required = true) int pageS,
			@RequestParam(value = "kelas", required = false) String kls,
			@RequestParam(value = "tahun", required = false) String thn,
			@RequestParam(value = "name", required = false) String nama
			) {
		Integer pageNumber = Integer.valueOf(pageN);
		Integer pageSize = Integer.valueOf(pageS);
		System.out.println( "data = " + kls + " " + thn + " " + nama);
		List<TblEvent> list = eventDao.findByKelasLikeAndTahunLikeAndNameLikeOrderByIdAsc("%" + kls + "%", "%" + thn + "%", "%" + nama + "%");
		TreeMap<String, Object> mappedList = getPagedMap(pageSize, pageNumber, list);
		return mappedList;
	}
	
	public TreeMap<String, Object> getPagedMap(Integer pageSize, Integer pageNumber, List<TblEvent> list) {
        log.info("Start Paging List");

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

		try {
			TreeMap<String, Object> tResp = new TreeMap<String, Object>();
			if (list.size() > 0) {
				tResp.put("items", listPaged.get(pageNumber - 1));
				tResp.put("total", list.size());
			} else {
				tResp.put("total", 0);
			}
			Thread.sleep(new Random().nextInt((2000 - 500) + 1) + 500);
			
	        log.info("Return Paged List");
			return tResp;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		return null;
	}
}
