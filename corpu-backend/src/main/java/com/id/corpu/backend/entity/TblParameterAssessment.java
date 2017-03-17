package com.id.corpu.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parameter_assessment")
public class TblParameterAssessment {

	private String id;
	private String parameter;
	private int value;
	private boolean active;

	@Id
	@Column(name = "id", nullable = false, length = 30)
	public String getId() {
		return id;
	}

	@Column(name = "parameter", nullable = false, length = 30)
	public void setId(String id) {
		this.id = id;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	@Column(name = "value", nullable = false, length = 10)
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Column(name = "active", nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
