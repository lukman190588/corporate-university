package com.diklatproject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
@IdClass(TblUserRoleId.class)
public class TblUserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5376455368167960942L;
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

}
