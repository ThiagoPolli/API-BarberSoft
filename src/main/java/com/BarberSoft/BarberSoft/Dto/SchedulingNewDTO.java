package com.BarberSoft.BarberSoft.Dto;

import java.io.Serializable;
import java.time.LocalDateTime;



public class SchedulingNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer id;
	private LocalDateTime dateAndTime;
	private String status;
	private Integer client_id;
	private Integer barber_id;
	private Integer service_type_id;
	
	
	public SchedulingNewDTO() {
		super();
	}


	public SchedulingNewDTO(Integer id, LocalDateTime dateAndTime, String status, Integer client_id, Integer barber_id,
			Integer service_type_id) {
		super();
		this.id = id;
		this.dateAndTime = dateAndTime;
		this.status = status;
		this.client_id = client_id;
		this.barber_id = barber_id;
		this.service_type_id = service_type_id;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}


	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getClient_id() {
		return client_id;
	}


	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}


	public Integer getBarber_id() {
		return barber_id;
	}


	public void setBarber_id(Integer barber_id) {
		this.barber_id = barber_id;
	}


	public Integer getService_type_id() {
		return service_type_id;
	}


	public void setService_type_id(Integer service_type_id) {
		this.service_type_id = service_type_id;
	}
	
	
}
