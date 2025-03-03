package com.BarberSoft.BarberSoft.Dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PaymentNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer id;
	private Double valuePayment;
	private String paymentMethod;
	private LocalDateTime timePayment;
	private Integer scheduling_id;
	
	public PaymentNewDTO() {
		
	}
	
	public PaymentNewDTO(Integer id, Double valuePayment, String paymentMethod, LocalDateTime timePayment,
			Integer scheduling_id) {
		super();
		this.id = id;
		this.valuePayment = valuePayment;
		this.paymentMethod = paymentMethod;
		this.timePayment = timePayment;
		this.scheduling_id = scheduling_id;
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

	public Integer getScheduling_id() {
		return scheduling_id;
	}

	public void setScheduling_id(Integer scheduling_id) {
		this.scheduling_id = scheduling_id;
	}

	
}
