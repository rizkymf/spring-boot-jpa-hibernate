package com.lawencon.parkiran.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_r_checkout")
public class CheckOut {
	
	@Id
	private Long outId;
	
	private LocalDateTime timeOut;
	
	@OneToOne
	@JoinColumn(name="in_code")
	private CheckIn inCode;

	public Long getOutId() {
		return outId;
	}

	public void setOutId(Long outId) {
		this.outId = outId;
	}

	public LocalDateTime getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(LocalDateTime timeOut) {
		this.timeOut = timeOut;
	}

	public CheckIn getInCode() {
		return inCode;
	}

	public void setInCode(CheckIn inCode) {
		this.inCode = inCode;
	}
	
	
}
