package com.BarberSoft.BarberSoft.Dto.Scheduling;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.BarberSoft.BarberSoft.Dto.Barber.BarberClientDTO;
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
	private BarberClientDTO barber;
	private ServiceType serviceType;

	public SchedulingDTO() {
			
		}

	public SchedulingDTO(Scheduling obj) {
		
		id = obj.getId() ;
		dateAndTime = obj.getDateAndTime();
		status = obj.getStatus();
		client = obj.getClient();
		barber = new BarberClientDTO(obj.getBarber().getId(), obj.getBarber().getName(), obj.getBarber().getSpecialty());
		serviceType = obj.getServiceType();
				
	}
	
    public SchedulingDTO(Integer id, LocalDateTime dateAndTime, String status, Client client, Barber barber, ServiceType serviceType) {
        this.id = id;
        this.dateAndTime = dateAndTime;
        this.status = status;
        this.client = client;
        this.barber = new BarberClientDTO(barber.getId(),barber.getName(), barber.getSpecialty()); 
        this.serviceType = serviceType;
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

	public BarberClientDTO getBarber() {
		return barber;
	}

	public void setBarber(BarberClientDTO barber) {
		this.barber = barber;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}
	
	
}
