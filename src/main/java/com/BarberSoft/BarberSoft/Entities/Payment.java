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
public class Payment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Double valuePayment;
	private String paymentMethod;
	private LocalDateTime timePayment;
	
	@ManyToOne
	@JoinColumn(name="scheduling_id")
	private Scheduling scheduling;

	public Payment() {
		
	}
	
	public Payment(Integer id, Double valuePayment, String paymentMethod, LocalDateTime timePayment,
			Scheduling scheduling) {
		super();
		this.id = id;
		this.valuePayment = valuePayment;
		this.paymentMethod = paymentMethod;
		this.timePayment = timePayment;
		this.scheduling = scheduling;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValuePayment() {
		return valuePayment;
	}

	public void setValuePayment(Double valuePayment) {
		this.valuePayment = valuePayment;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDateTime getTimePayment() {
		return timePayment;
	}

	public void setTimePayment(LocalDateTime timePayment) {
		this.timePayment = timePayment;
	}

	public Scheduling getScheduling() {
		return scheduling;
	}

	public void setScheduling(Scheduling scheduling) {
		this.scheduling = scheduling;
	}
	
	
	
}
