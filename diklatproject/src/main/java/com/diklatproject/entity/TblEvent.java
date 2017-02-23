package com.diklatproject.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "event")
public class TblEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2632836621536956615L;
	private String id;
	private String kelas;
	private int tahun;
	private String name;
	private Date startDate;
	private Date endDate;
	private int batch;
	private String group;
	private String event;
	private String method;
	private boolean internal;
	private boolean open;
	private int quota;
	private int totalTime;
	private String provider;
	private String place;
	private String location;
	private String pic;
	private BigDecimal cost;
	private int result;

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

	@Column(name = "tahun", nullable = false, length = 4)
	public int getTahun() {
		return tahun;
	}

	public void setTahun(int tahun) {
		this.tahun = tahun;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", nullable = false)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = false)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "batch", nullable = false, length = 10)
	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	@Column(name = "group", nullable = false, length = 30)
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Column(name = "event", nullable = false, length = 30)
	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Column(name = "method", nullable = false, length = 2)
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Column(name = "internal", nullable = false)
	public boolean isInternal() {
		return internal;
	}

	public void setInternal(boolean internal) {
		this.internal = internal;
	}

	@Column(name = "open", nullable = false)
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	@Column(name = "quota", nullable = false, length = 10)
	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	@Column(name = "total_time", nullable = false, length = 10)
	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	@Column(name = "provider", nullable = false, length = 30)
	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	@Column(name = "place", nullable = false)
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Column(name = "location", nullable = false, length = 30)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "pic", nullable = false, length = 10)
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Column(name = "cost", precision = 15, scale = 2)
	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	@Column(name = "result", nullable = false)
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
