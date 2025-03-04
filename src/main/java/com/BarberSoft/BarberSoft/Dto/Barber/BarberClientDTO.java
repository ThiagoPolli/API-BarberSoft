package com.BarberSoft.BarberSoft.Dto.Barber;

import java.io.Serializable;

import com.BarberSoft.BarberSoft.Entities.Barber;

public class BarberClientDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	private String name;
	private String specialty;
	
	
	public BarberClientDTO() {
		
	}
	
	public BarberClientDTO(Integer id, String name, String specialty) {
		super();
		this.id = id;
		this.name = name;
		this.specialty = specialty;
	}

	public BarberClientDTO(Barber obj) {
		id = obj.getId();
		name = obj.getName();
		specialty = obj.getSpecialty();
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
	
}
