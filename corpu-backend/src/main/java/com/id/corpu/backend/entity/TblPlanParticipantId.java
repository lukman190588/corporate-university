package com.id.corpu.backend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class TblPlanParticipantId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8582712935087351563L;
	private String idEvent;
	private String idKelas;
	private int idParticipant;

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TblPlanParticipantId))
			return false;
		TblPlanParticipantId castOther = (TblPlanParticipantId) other;

		return ((this.getIdEvent() == castOther.getIdEvent()) || (this.getIdEvent() != null && castOther.getIdEvent() != null && this.getIdEvent().equals(castOther.getIdEvent()))) 
				&& ((this.getIdKelas() == castOther.getIdKelas()) || (this.getIdKelas() != null && castOther.getIdKelas() != null && this.getIdKelas().equals(castOther.getIdKelas())))
				&& ((this.getIdParticipant() == castOther.getIdParticipant()) || (this.getIdParticipant() > 0 && castOther.getIdParticipant() > 0 && this.getIdParticipant() == castOther.getIdParticipant()));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdEvent() == null ? 0 : this.getIdEvent().hashCode());
		result = 37 * result + (getIdKelas() == null ? 0 : this.getIdKelas().hashCode());
		result = 37 * result + (getIdParticipant() > 0 ? 0 : this.getIdEvent().hashCode());
		return result;
	}
}
