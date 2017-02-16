package com.diklatproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diklatproject.dao.TblMateriDao;
import com.diklatproject.entity.TblMateri;

@RestController
public class CustomController {

	@Autowired
	private TblMateriDao materiDao;
	
	@RequestMapping("/getAll")
	public List<TblMateri> getAllMateri() {
		List<TblMateri> listMater = (List<TblMateri>) materiDao.findAll();
		
		return listMater;
	}
}
