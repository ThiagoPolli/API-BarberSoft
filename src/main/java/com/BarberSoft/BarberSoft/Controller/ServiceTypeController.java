package com.BarberSoft.BarberSoft.Controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.BarberSoft.BarberSoft.Dto.ServiceType.ServiceTypeDTO;
import com.BarberSoft.BarberSoft.Entities.ServiceType;
import com.BarberSoft.BarberSoft.Services.ServiceTypeService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "api/serviceType")
@Tag(name = "ServiceType", description = "ServiceType APIs")
public class ServiceTypeController {
	
	@Autowired
	private ServiceTypeService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ServiceTypeDTO>> findAll(){
		List<ServiceType> serviceTypes = service.findAllService();
		List<ServiceTypeDTO> serviceTypeDTOs = serviceTypes.stream().map(obj -> new ServiceTypeDTO(obj))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(serviceTypeDTOs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ServiceType> findbyId(@PathVariable Integer id){
		ServiceType serServiceType = service.findByIdService(id);
		return ResponseEntity.ok().body(serServiceType);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ServiceType> update(@RequestBody ServiceTypeDTO dto, @PathVariable Integer id){
		ServiceType serviceType = service.fromDto(dto);
		serviceType.setId(id);
		serviceType = service.updateService(serviceType);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ServiceTypeDTO dto){
		ServiceType serviceType = service.fromDto(dto);
		serviceType = service.insertService(serviceType);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(serviceType.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	

}
