package com.BarberSoft.BarberSoft.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double price;
	private Integer qtd;
	
	private LocalDateTime creatAtUpdate;
	
	@ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

	public Product() {
		
	}

	public Product(Integer id, String name, Double price, Integer qtd, LocalDateTime creatAtUpdate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.qtd = qtd;
		this.creatAtUpdate = creatAtUpdate;
		
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

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public LocalDateTime getCreatAtUpdate() {
		return creatAtUpdate;
	}

	public void setCreatAtUpdate(LocalDateTime data) {
		this.creatAtUpdate = data;
	}

	
}
