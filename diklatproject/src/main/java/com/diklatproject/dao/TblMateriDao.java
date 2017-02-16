package com.diklatproject.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.diklatproject.entity.TblMateri;

@Transactional
public interface TblMateriDao extends CrudRepository<TblMateri, String>{

	public TblMateri findByNama(String nama);
}
