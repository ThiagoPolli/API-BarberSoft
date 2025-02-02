package com.BarberSoft.BarberSoft.Dto;

import java.io.Serializable;

import com.BarberSoft.BarberSoft.Entities.Barber;

public class BarberDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	private String name;
	private String specialty;
	private String commission;
	private String workingHours;
	
	
	public BarberDTO() {
		
	}
	
	public BarberDTO(Barber obj) {
		id = obj.getId();
		name = obj.getName();
		specialty = obj.getSpecialty();
		commission = obj.getCommission();
		workingHours = obj.getWorkingHours();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}
	
	
	
}
