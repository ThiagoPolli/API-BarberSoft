package com.BarberSoft.BarberSoft.Dto.ServiceType;

import java.io.Serializable;

import com.BarberSoft.BarberSoft.Entities.ServiceType;


public class ServiceTypeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	
	
	private Integer id;
	private String name;
	private Double price;
	private String estimatedTime;
	
	public ServiceTypeDTO() {
		
	}
	
	public ServiceTypeDTO(ServiceType obj) {
		id = obj.getId();
		name = obj.getName();
		price = obj.getPrice();
		estimatedTime = obj.getEstimatedTime(); 
		
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	
	

}
