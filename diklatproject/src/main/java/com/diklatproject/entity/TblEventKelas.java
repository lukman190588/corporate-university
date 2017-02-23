package com.diklatproject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event_kelas")
public class TblEventKelas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2870837598962268840L;
	private String idEvent;
	private String idKelas;
	private String idLesson;
	private String instructor;

	@Id
	@Column(name = "id_event", nullable = false, length = 30)
	public String getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(String idEvent) {
		this.idEvent = idEvent;
	}

	@Id
	@Column(name = "id_kelas", nullable = false, length = 30)
	public String getIdKelas() {
		return idKelas;
	}

	public void setIdKelas(String idKelas) {
		this.idKelas = idKelas;
	}

	@Id
	@Column(name = "id_lesson", nullable = false, length = 30)
	public String getIdLesson() {
		return idLesson;
	}

	public void setIdLesson(String idLesson) {
		this.idLesson = idLesson;
	}

	@Column(name = "instructor", nullable = false, length = 30)
	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

}
