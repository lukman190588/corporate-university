package com.diklatproject.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.diklatproject.entity.TblMateri;

public interface MateriRepo extends CrudRepository<TblMateri, Long> {

	List<TblMateri> findByNama(String nama);
}
