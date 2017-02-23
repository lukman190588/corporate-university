package com.diklatproject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_permission")
public class TblRolePermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7473858173193383014L;
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
}
