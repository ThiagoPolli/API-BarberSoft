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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.BarberSoft.BarberSoft.Dto.BarberDTO;
import com.BarberSoft.BarberSoft.Entities.Barber;
import com.BarberSoft.BarberSoft.Services.BarberService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "api/barber")
public class BarberController {
	
	@Autowired
	private BarberService service;
	
	//Listar todos os Barbeiros
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BarberDTO>> findAll(){
		List<Barber> barbers = service.findAllService();
		List<BarberDTO> barberDtos =  barbers.stream().map(obj -> new BarberDTO(obj))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(barberDtos);
	}
	
	//Buscar por ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Barber> findById(@PathVariable Integer id){
		
		Barber barber = service.findByIdService(id);
		return ResponseEntity.ok().body(barber);
	}
	
	//Buscar por especialidade
	@RequestMapping(value = "/search/specialty", method = RequestMethod.GET)
	public ResponseEntity<List<Barber>> searchSpecialty(@RequestParam(value = "name", defaultValue = "") String specialty){
		List<Barber> barbers = service.searchSpecialtyService(specialty);
		return ResponseEntity.ok().body(barbers);
	}
	
	//buscar po nome
	@RequestMapping(value = "/search/name", method = RequestMethod.GET)
	public ResponseEntity<List<Barber>> searchName(@RequestParam(value = "name", defaultValue = "") String name){
		List<Barber> barbers = service.searchSNameService(name);
		return ResponseEntity.ok().body(barbers);
	}
	
	//Buscar por horario de trabalho 
	@RequestMapping(value = "/search/workingHours", method = RequestMethod.GET)
	public ResponseEntity<List<Barber>> searchWorkingHours(@RequestParam(value = "name", defaultValue = "") String workingHours){
		List<Barber> barbers = service.searchWorkingHoursService(workingHours);
		return ResponseEntity.ok().body(barbers);
	}
	
	//Atualizar Barbeiro
	@RequestMapping(value = "/{id}", method =  RequestMethod.PUT)
	public ResponseEntity<Barber> update(@RequestBody @Valid BarberDTO dto, @PathVariable Integer id){
		Barber barber = service.fromDto(dto);
		barber.setId(id);
		barber = service.updateService(barber);
		return ResponseEntity.noContent().build();
	}
	
	//Inserir novo Barbeiro
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody @Valid BarberDTO dto){
		Barber barber = service.fromDto(dto);
		barber = service.insertService(barber);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(barber.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
