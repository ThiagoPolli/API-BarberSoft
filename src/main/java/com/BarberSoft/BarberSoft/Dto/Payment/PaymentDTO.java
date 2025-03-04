package com.BarberSoft.BarberSoft.Dto.Payment;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.BarberSoft.BarberSoft.Dto.Scheduling.SchedulingDTO;
import com.BarberSoft.BarberSoft.Entities.Payment;

public class PaymentDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private Integer id;
	private Double valuePayment;
	private String paymentMethod;
	private LocalDateTime timePayment;
	private SchedulingDTO schedulingDto;
	
	public PaymentDTO() {
	}
	
	
	public PaymentDTO( Payment obj ) {
		super();
		this.id = obj.getId();
		this.valuePayment = obj.getValuePayment();
		this.paymentMethod = obj.getPaymentMethod();
		this.timePayment = obj.getTimePayment();
		
		 if (obj.getScheduling() != null) { 
		        this.schedulingDto = new SchedulingDTO(
		            obj.getScheduling().getId(),
		            obj.getScheduling().getDateAndTime(),
		            obj.getScheduling().getStatus(),
		            obj.getScheduling().getClient(),
		            obj.getScheduling().getBarber(),
		            obj.getScheduling().getServiceType()
		        );
		    } else {
		        this.schedulingDto = null; 
		    }	
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
	public SchedulingDTO getSchedulingDto() {
		return schedulingDto;
	}
	public void setSchedulingDto(SchedulingDTO schedulingDto) {
		this.schedulingDto = schedulingDto;
	}
	
	
}
