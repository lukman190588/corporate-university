package com.diklatproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diklatproject.entity.TblMateri;

public interface TblMateriDao extends JpaRepository<TblMateri, String>{

	List<TblMateri> findByNamaLikeAndTipeAndWaktu(String nama, String tipe, int waktu);
	
	List<TblMateri> findById(String id);
	
	@Query("select m from TblMateri m where m.nama like :nama and m.tipe = :tipe and m.waktu = :tipe")
	List<TblMateri> findMateriBy(String nama, String tipe, int waktu);
	
}
