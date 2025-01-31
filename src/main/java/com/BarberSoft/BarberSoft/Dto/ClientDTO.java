package com.BarberSoft.BarberSoft.Dto;

import java.io.Serializable;
import java.util.Date;

import com.BarberSoft.BarberSoft.Entities.Client;

public class ClientDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String phone;
	private String email;
	private Date dateOfBirth;
	
	
	public ClientDTO() {
		
	}

	public ClientDTO(Client obj) {
		id = obj.getId();
		name = obj.getName();
		phone = obj.getPhone();
		email = obj.getEmail();
		dateOfBirth = obj.getDateOfBirth();		
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

}
