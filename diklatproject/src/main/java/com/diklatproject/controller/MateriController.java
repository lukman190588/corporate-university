package com.diklatproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diklatproject.dao.TblMateriDao;
import com.diklatproject.entity.Greeting;
import com.diklatproject.entity.TblMateri;

@RestController
public class MateriController {

	@Autowired
	private TblMateriDao materiDao;

	/**
	 * RequestMapping request all records from tblmateri
	 * @return
	 */
	@RequestMapping("/semua-materi")
	public List<TblMateri> getAllMateri() {
		List<TblMateri> listMater = (List<TblMateri>) materiDao.findAll();

		return listMater;
	}

	/**
	 * RequestMapping with fixed PathVariable 
	 * @param nama
	 * @param tipe
	 * @param waktu
	 * @return
	 */
	@RequestMapping("/materi/search/{tipe}-{waktu}")
	public List<TblMateri> addMateri(@PathVariable String nama, @PathVariable String tipe, @PathVariable int waktu) {
		TblMateri materi = new TblMateri(nama, tipe, waktu);
		Example<TblMateri> exMateri = Example.of(materi);
		List<TblMateri> listMateri = materiDao.findAll(exMateri);
		return listMateri;
	}

	/**
	 * RequestMapping with RequestParam required true and-or false
	 * @param nama
	 * @param tipe
	 * @param waktu
	 * @returns
	 */
	@RequestMapping(value = "/materi/search")
	public List<TblMateri> getMateriByParam(
			@RequestParam(value = "nama", required = false) String nama,
			@RequestParam(value = "tipe", required = true) String tipe,
			@RequestParam(value = "waktu", required = true) int waktu) {
		List<TblMateri> listMateri = materiDao.findByNamaLikeAndTipeAndWaktu("%" + nama + "%", tipe, waktu);
		return listMateri;
	}

	/**
	 * RequestMapping test hardcoded id
	 * @return
	 */
	@RequestMapping("/materi-pertama")
	public TblMateri getMateri() {
		TblMateri listMateri = materiDao.findOne("11001");
		return listMateri;
	}

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(1, "Hello World");
	}
}
