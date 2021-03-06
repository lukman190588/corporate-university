package com.id.corpu.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.id.corpu.backend.entity.TblEvent;

public interface TblEventDao extends JpaRepository<TblEvent, String> {

	List<TblEvent> findById(String id);
	
	TblEvent findByIdAndKelas(String id, String kelas);
	
	List<TblEvent> findByKelasLikeAndTahunLikeAndNameLikeOrderByIdAsc(String kelas, String tahun, String name);
}
