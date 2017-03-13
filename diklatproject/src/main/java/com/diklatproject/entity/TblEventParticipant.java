package com.diklatproject.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "event_participant")
@IdClass(TblEventParticipantId.class)
public class TblEventParticipant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8961786378627592758L;
	private String idEvent;
	private String idKelas;
	private int idParticipant;
	private BigDecimal resultAssessment;
	private String testimonials;

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

	@Column(name = "result_assessment", precision = 10, scale = 2)
	public BigDecimal getResultAssessment() {
		return resultAssessment;
	}

	public void setResultAssessment(BigDecimal resultAssessment) {
		this.resultAssessment = resultAssessment;
	}

	@Column(name = "testimonials")
	public String getTestimonials() {
		return testimonials;
	}

	public void setTestimonials(String testimonials) {
		this.testimonials = testimonials;
	}

}
