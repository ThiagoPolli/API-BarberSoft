package com.BarberSoft.BarberSoft.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.BarberSoft.BarberSoft.Dto.Scheduling.SchedulingDTO;
import com.BarberSoft.BarberSoft.Dto.Scheduling.SchedulingNewDTO;
import com.BarberSoft.BarberSoft.Entities.Barber;
import com.BarberSoft.BarberSoft.Entities.Client;
import com.BarberSoft.BarberSoft.Entities.Scheduling;
import com.BarberSoft.BarberSoft.Entities.ServiceType;
import com.BarberSoft.BarberSoft.Repositories.SchedulingRepository;
import com.BarberSoft.BarberSoft.Services.Exception.ObjectNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class SchedulingService {
	
	@Autowired
	private SchedulingRepository repository;
	
	@Autowired
	private ClieintService clieintService;
	
	@Autowired
	private BarberService barberService;
	
	@Autowired
	private ServiceTypeService serviceTypeService;
	
	
	public List<Scheduling> findAllService(){
		return repository.findAll();
	}
	
	public Scheduling findById(Integer id) {
	    Optional<Scheduling> scheduling = repository.findById(id);

	    return scheduling.orElseThrow(() -> 
	        new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Scheduling.class.getName())
	    );

	    
	}

	public SchedulingDTO findByIdService(Integer id) {
	    Optional<Scheduling> scheduling = repository.findById(id);

	    Scheduling entity = scheduling.orElseThrow(() -> 
	        new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Scheduling.class.getName())
	    );

	    return new SchedulingDTO(entity); // Retornando o DTO em vez da entidade completa
	}
	
	@Transactional
	public Scheduling insertService(SchedulingNewDTO obj) {
		
		obj.setId(null);
		Integer idClient = obj.getClient_id();
		Integer idBarber = obj.getBarber_id();
		Integer idServiceType = obj.getService_type_id();
		
		Client client = clieintService.findByIdService(idClient);
		Barber barber = barberService.findByIdService(idBarber);
		ServiceType serviceType = serviceTypeService.findByIdService(idServiceType);
		
		Scheduling scheduling = new Scheduling();
		 
		scheduling.setDateAndTime(obj.getDateAndTime());
		scheduling.setStatus(obj.getStatus());
		scheduling.setClient(client);
		scheduling.setBarber(barber);
		scheduling.setServiceType(serviceType);
		
			 		
		return repository.save(scheduling);
	}
	
	public Scheduling updateService(Integer id, SchedulingNewDTO obj) {
		obj.setId(null);
		Client client = clieintService.findByIdService(obj.getClient_id());
		Barber barber = barberService.findByIdService(obj.getBarber_id());
		ServiceType serviceType = serviceTypeService.findByIdService(obj.getService_type_id());
		
		return repository.findById(id).map(entity -> {
			entity.setId(id);
			entity.setDateAndTime(obj.getDateAndTime());
			entity.setStatus(obj.getStatus());
			entity.setClient(client);
			entity.setBarber(barber);
			entity.setServiceType(serviceType);
			return repository.save(entity);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agenda Não encontrado"));
	}

}















