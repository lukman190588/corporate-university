package com.diklatproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diklatproject.dao.MateriRepo;
import com.diklatproject.entity.Greeting;
import com.diklatproject.entity.TblMateri;

@RestController
public class MateriController {

	@Autowired
	MateriRepo materiService;

	@RequestMapping("/materi/save/{nama}{tipe}{waktu}{keterangan}")
	public TblMateri addMateri(@PathVariable String nama, @PathVariable String tipe, @PathVariable int waktu) {
		TblMateri materi = new TblMateri(nama, tipe, waktu);
		return materi;
	}

	@RequestMapping("/materi")
	public TblMateri getMateri() {
		TblMateri listMateri = materiService.findOne((long) 11001);
		return listMateri;
	}

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(1, "Hello World");

	}	
}
