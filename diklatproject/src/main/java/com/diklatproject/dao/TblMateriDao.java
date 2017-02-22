package com.diklatproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diklatproject.entity.TblMateri;
import java.lang.String;
import java.util.List;

public interface TblMateriDao extends JpaRepository<TblMateri, String>{

	public TblMateri findByNama(String nama);
	
	List<TblMateri> findById(String id);
	
	@Query("select m from tbl_materi m where m.nama = :nama and u.tipe = :tipe")
	List<TblMateri> findMateriBy();
}
