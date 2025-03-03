package com.BarberSoft.BarberSoft.Dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.BarberSoft.BarberSoft.Entities.Barber;
import com.BarberSoft.BarberSoft.Entities.Client;
import com.BarberSoft.BarberSoft.Entities.Scheduling;
import com.BarberSoft.BarberSoft.Entities.ServiceType;

public class SchedulingDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private LocalDateTime dateAndTime;
	private String status;
	private Client client;
	private Barber barber;
	private ServiceType serviceType;

	public SchedulingDTO() {
			
		}

	public SchedulingDTO(Scheduling obj) {
		
		id = obj.getId() ;
		dateAndTime = obj.getDateAndTime();
		status = obj.getStatus();
		client = obj.getClient();
		barber = obj.getBarber();
		serviceType = obj.getServiceType();
				
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Barber getBarber() {
		return barber;
	}

	public void setBarber(Barber barber) {
		this.barber = barber;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}
	
	
}
