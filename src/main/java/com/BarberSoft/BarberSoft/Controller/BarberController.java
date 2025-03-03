package com.BarberSoft.BarberSoft.Controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.BarberSoft.BarberSoft.Dto.BarberDTO;
import com.BarberSoft.BarberSoft.Entities.Barber;
import com.BarberSoft.BarberSoft.Services.BarberService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "api/barber")
@Tag(name = "Barber", description = "Barber APIs")
public class BarberController {
	
	@Autowired
	private BarberService service;
	
	//Listar todos os Barbeiros
	@GetMapping
	public ResponseEntity<List<BarberDTO>> findAll(){
		List<Barber> barbers = service.findAllService();
		List<BarberDTO> barberDtos =  barbers.stream().map(obj -> new BarberDTO(obj))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(barberDtos);
	}
	
	//Buscar por ID
	@GetMapping("/{id}")
	public ResponseEntity<Barber> findById(@PathVariable Integer id){
		
		Barber barber = service.findByIdService(id);
		return ResponseEntity.ok().body(barber);
	}
	
	//Buscar por especialidade
	@GetMapping("/search/specialty")
	public ResponseEntity<List<Barber>> searchSpecialty(@RequestParam(value = "specialty", defaultValue = "") String specialty){
		List<Barber> barbers = service.searchSpecialtyService(specialty);
		return ResponseEntity.ok().body(barbers);
	}
	
	//buscar po nome
	@GetMapping("/search/name")
	public ResponseEntity<List<Barber>> searchName(@RequestParam(value = "name", defaultValue = "") String name){
		List<Barber> barbers = service.searchSNameService(name);
		return ResponseEntity.ok().body(barbers);
	}
	
	//Buscar por horario de trabalho 
	@GetMapping("/search/workingHours")
	public ResponseEntity<List<Barber>> searchWorkingHours(@RequestParam(value = "workingHours", defaultValue = "") String workingHours){
		List<Barber> barbers = service.searchWorkingHoursService(workingHours);
		return ResponseEntity.ok().body(barbers);
	}
	
	//buscar po nome
		@GetMapping("/search/commission")
		public ResponseEntity<List<Barber>> searchcCommission(@RequestParam(value = "commission", defaultValue = "") String commission){
			List<Barber> barbers = service.searchCommissionService(commission);
			return ResponseEntity.ok().body(barbers);
		}
	
	//Atualizar Barbeiro
	@PutMapping("/{id}")
	public ResponseEntity<Barber> update(@RequestBody @Valid BarberDTO dto, @PathVariable Integer id){
		Barber barber = service.fromDto(dto);
		barber.setId(id);
		barber = service.updateService(barber);
		return ResponseEntity.noContent().build();
	}
	
	//Inserir novo Barbeiro
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody @Valid BarberDTO dto){
		Barber barber = service.fromDto(dto);
		barber = service.insertService(barber);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(barber.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
