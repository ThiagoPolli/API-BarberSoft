package com.BarberSoft.BarberSoft.Entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ServiceType implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double price;
	private String estimatedTime;
	
	
	
	
	public ServiceType() {
	}




	public ServiceType(Integer id, String name, Double price, String estimatedTime) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.estimatedTime = estimatedTime;
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
