package com.diklatproject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class TblRolePermissionId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2734280172551657809L;
	private String idRole;
	private String idPermission;

	@Id
	@Column(name = "id_role", nullable = false, length = 30)
	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	@Id
	@Column(name = "id_permission", nullable = false, length = 30)
	public String getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(String idPermission) {
		this.idPermission = idPermission;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TblRolePermissionId))
			return false;
		TblRolePermissionId castOther = (TblRolePermissionId) other;

		return ((this.getIdRole() == castOther.getIdRole()) || (this.getIdRole() != null && castOther.getIdRole() != null && this.getIdRole().equals(castOther.getIdRole())))
				&& ((this.getIdPermission() == castOther.getIdPermission()) || (this.getIdPermission() != null && castOther.getIdPermission() != null && this.getIdPermission().equals(castOther.getIdPermission())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdRole() == null ? 0 : this.getIdRole().hashCode());
		result = 37 * result + (getIdPermission() == null ? 0 : this.getIdPermission().hashCode());
		return result;
	}
}
