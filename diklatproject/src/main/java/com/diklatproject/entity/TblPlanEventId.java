package com.diklatproject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class TblPlanEventId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4109344102383980692L;
	private String id;
	private String kelas;

	@Id
	@Column(name = "id", nullable = false, length = 30)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "kelas", nullable = false, length = 30)
	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TblPlanEventId))
			return false;
		TblPlanEventId castOther = (TblPlanEventId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
				&& ((this.getKelas() == castOther.getKelas()) || (this.getKelas() != null && castOther.getKelas() != null && this.getKelas().equals(castOther.getKelas())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result + (getKelas() == null ? 0 : this.getKelas().hashCode());
		return result;
	}
}
