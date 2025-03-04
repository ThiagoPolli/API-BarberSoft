package com.BarberSoft.BarberSoft.Dto.Client;

import java.io.Serializable;
import java.util.Date;

import com.BarberSoft.BarberSoft.Entities.Client;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;

public class ClientDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String name;
	
	@NotEmpty(message = "{campo.fone.obrigatorio}")
	private String phone;
	private String email;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
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
