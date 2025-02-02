package com.BarberSoft.BarberSoft.Entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Barber implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String specialty;
	private String commission;
	private String workingHours;
	
	
	public Barber() {
		
	}


	public Barber(Integer id, String name, String specialty, String commission, String workingHours) {
		this.id = id;
		this.name = name;
		this.specialty = specialty;
		this.commission = commission;
		this.workingHours = workingHours;
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
