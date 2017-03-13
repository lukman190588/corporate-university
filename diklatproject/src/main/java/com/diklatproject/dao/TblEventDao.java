package com.diklatproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diklatproject.entity.TblEvent;
import java.lang.String;

public interface TblEventDao extends JpaRepository<TblEvent, String> {

	List<TblEvent> findById(String id);
}
