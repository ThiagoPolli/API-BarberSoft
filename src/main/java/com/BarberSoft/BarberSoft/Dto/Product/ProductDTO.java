package com.BarberSoft.BarberSoft.Dto.Product;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.BarberSoft.BarberSoft.Entities.Product;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Double price;
	private Integer qtd;
	private LocalDateTime creatAtUpdate;

	public ProductDTO() {

	}

	public ProductDTO(Product obj) {

		id = obj.getId();
		name = obj.getName();
		price = obj.getPrice();
		qtd = obj.getQtd();
		creatAtUpdate = obj.getCreatAtUpdate();
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

	public void setCreatAtUpdate(LocalDateTime creatAtUpdate) {
		this.creatAtUpdate = creatAtUpdate;
	}

}
