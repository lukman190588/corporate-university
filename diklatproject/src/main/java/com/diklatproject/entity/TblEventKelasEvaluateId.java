package com.diklatproject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class TblEventKelasEvaluateId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4718801125416639187L;
	private String idEvent;
	private String idKelas;
	private String idLesson;
	private int idParticipant;
	private String idSurvey;

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TblEventKelasEvaluateId))
			return false;
		TblEventKelasEvaluateId castOther = (TblEventKelasEvaluateId) other;

		return ((this.getIdEvent() == castOther.getIdEvent()) || (this.getIdEvent() != null && castOther.getIdEvent() != null && this.getIdEvent().equals(castOther.getIdEvent()))) 
				&& ((this.getIdKelas() == castOther.getIdKelas()) || (this.getIdKelas() != null && castOther.getIdKelas() != null && this.getIdKelas().equals(castOther.getIdKelas())))
				&& ((this.getIdLesson() == castOther.getIdLesson()) || (this.getIdLesson() != null && castOther.getIdLesson() != null && this.getIdLesson().equals(castOther.getIdLesson())))
				&& ((this.getIdParticipant() == castOther.getIdParticipant()) || (this.getIdParticipant() > 0 && castOther.getIdParticipant() > 0 && this.getIdParticipant() == castOther.getIdParticipant()))
				&& ((this.getIdSurvey() == castOther.getIdSurvey()) || (this.getIdSurvey() != null && castOther.getIdSurvey() != null && this.getIdSurvey().equals(castOther.getIdSurvey())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdEvent() == null ? 0 : this.getIdEvent().hashCode());
		result = 37 * result + (getIdKelas() == null ? 0 : this.getIdKelas().hashCode());
		result = 37 * result + (getIdLesson() == null ? 0 : this.getIdLesson().hashCode());
		result = 37 * result + (getIdParticipant() > 0 ? 0 : this.getIdEvent().hashCode());
		result = 37 * result + (getIdSurvey() == null ? 0 : this.getIdSurvey().hashCode());
		return result;
	}
}
