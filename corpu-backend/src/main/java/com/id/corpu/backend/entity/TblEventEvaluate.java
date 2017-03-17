package com.id.corpu.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "event_evaluate")
@IdClass(TblEventEvaluateId.class)
public class TblEventEvaluate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5233050267878636042L;
	private String idEvent;
	private String idKelas;
	private int idParticipant;
	private String idSurvey;
	private BigDecimal result;
	private String desc;

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
	@Column(name = "id_participant", nullable = false, length = 10)
	public int getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
	}

	@Id
	@Column(name = "id_survey", nullable = false, length = 30)
	public String getIdSurvey() {
		return idSurvey;
	}

	public void setIdSurvey(String idSurvey) {
		this.idSurvey = idSurvey;
	}

	@Column(name = "result", precision = 10, scale = 2)
	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}

	@Column(name = "desc", nullable = false)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
