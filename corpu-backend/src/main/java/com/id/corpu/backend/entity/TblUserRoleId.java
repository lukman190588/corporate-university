package com.id.corpu.backend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class TblUserRoleId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6926282041974406766L;
	private String idUser;
	private String idRole;

	@Id
	@Column(name = "id_user", nullable = false, length = 30)
	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	@Id
	@Column(name = "id_role", nullable = false, length = 30)
	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TblUserRoleId))
			return false;
		TblUserRoleId castOther = (TblUserRoleId) other;

		return ((this.getIdUser() == castOther.getIdUser()) || (this.getIdUser() != null && castOther.getIdUser() != null && this.getIdUser().equals(castOther.getIdUser())))
				&& ((this.getIdRole() == castOther.getIdRole()) || (this.getIdRole() != null && castOther.getIdRole() != null && this.getIdRole().equals(castOther.getIdRole())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdUser() == null ? 0 : this.getIdUser().hashCode());
		result = 37 * result + (getIdRole() == null ? 0 : this.getIdRole().hashCode());
		return result;
	}
}
