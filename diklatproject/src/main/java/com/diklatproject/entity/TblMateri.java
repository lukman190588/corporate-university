package com.diklatproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_materi")
public class TblMateri {

	private String id;
	private String nama;
	private String tipe;
	private int waktu;

	public TblMateri() {
	}
	
	public TblMateri(String nama, String tipe, int waktu) {
		this.nama = nama;
		this.tipe = tipe;
		this.waktu = waktu;
	}

	@Id
    @Column(name = "id", nullable = false, length = 30)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    @Column(name = "nama", nullable = false, length = 50)
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

    @Column(name = "tipe", nullable = false, length = 1)
	public String getTipe() {
		return tipe;
	}

	public void setTipe(String tipe) {
		this.tipe = tipe;
	}

	@Column(name = "waktu", nullable = false, length = 3)
	public int getWaktu() {
		return waktu;
	}

	public void setWaktu(int waktu) {
		this.waktu = waktu;
	}

}
