package com.lawencon.parkiran.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.lawencon.parkiran.models.VehicleType;

@Entity
@Table(name = "tb_r_checkin", uniqueConstraints = {
		@UniqueConstraint(name = "in_uk", columnNames = { "plate", "dateIn" }) })
public class CheckIn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inId;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private VehicleType vehicleType;

	private String plate;
	private LocalDateTime timeIn = LocalDateTime.now();
	private LocalDate dateIn = LocalDate.now();
	private String inCode;

	public CheckIn() {
		super();
	}

	public CheckIn(Long inId, VehicleType vehicleType, String plate, LocalDateTime timeIn, String inCode) {
		super();
		this.inId = inId;
		this.vehicleType = vehicleType;
		this.plate = plate;
		this.timeIn = timeIn;
		this.inCode = inCode;
	}

	public Long getInId() {
		return inId;
	}

	public void setInId(Long inId) {
		this.inId = inId;
	}

	public VehicleType getTypeId() {
		return vehicleType;
	}

	public void setTypeId(VehicleType typeId) {
		this.vehicleType = typeId;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public LocalDateTime getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(LocalDateTime timeIn) {
		this.timeIn = timeIn;
	}

	public String getInCode() {
		return inCode;
	}

	public void setInCode(String inCode) {
		this.inCode = inCode;
	}

	public LocalDate getDateIn() {
		return dateIn;
	}

	public void setDateIn(LocalDate dateIn) {
		this.dateIn = dateIn;
	}
}
