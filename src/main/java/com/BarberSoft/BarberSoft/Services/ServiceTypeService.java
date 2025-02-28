package com.BarberSoft.BarberSoft.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.BarberSoft.BarberSoft.Dto.ServiceTypeDTO;
import com.BarberSoft.BarberSoft.Entities.ServiceType;
import com.BarberSoft.BarberSoft.Repositories.ServiceTypeRepository;
import com.BarberSoft.BarberSoft.Services.Exception.ObjectNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ServiceTypeService {
	
	@Autowired
	private ServiceTypeRepository repository;
	
	
	public List<ServiceType> findAllService() {
		return repository.findAll();
	}
	
	public ServiceType findByIdService(Integer id) {
		Optional<ServiceType> servicetype = repository.findById(id);
		
		return servicetype.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id + " Tipo: " + ServiceType.class.getName()));
	}

	
	@Transactional
	public ServiceType insertService(ServiceType obj) {
		try {
			obj.setId(null);
			obj = repository.save(obj);
			
			return obj;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Transactional
	public ServiceType updateService(ServiceType obj) {
		try {
			ServiceType serviceType = findByIdService(obj.getId());
			
			updateData(serviceType, obj);
			
			return repository.save(serviceType);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	private void updateData(ServiceType serviceType, ServiceType obj) {
		serviceType.setName(obj.getName());
		serviceType.setPrice(obj.getPrice());
		serviceType.setEstimatedTime(obj.getEstimatedTime());
		
	}
	
	public ServiceType fromDto(ServiceTypeDTO objdto) {
		ServiceType serviceType = new ServiceType(
				null,
				objdto.getName(),
				objdto.getPrice(),
				objdto.getEstimatedTime());
		return serviceType;
	}
}
