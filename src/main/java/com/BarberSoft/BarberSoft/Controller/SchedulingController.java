package com.BarberSoft.BarberSoft.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.BarberSoft.BarberSoft.Dto.SchedulingDTO;
import com.BarberSoft.BarberSoft.Dto.SchedulingNewDTO;
import com.BarberSoft.BarberSoft.Entities.Scheduling;
import com.BarberSoft.BarberSoft.Services.SchedulingService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "api/scheduling")
@Tag(name = "Scheduling", description = "Scheduling APIs")
public class SchedulingController {
	
	@Autowired
	private SchedulingService service;
	
	//Listar todos os Barbeiros
	@GetMapping
	public ResponseEntity<List<SchedulingDTO>> findAll(){
		List<Scheduling> schedulings = service.findAllService();
		List<SchedulingDTO> schedulingDTOs =  schedulings.stream().map(obj -> new SchedulingDTO(obj))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(schedulingDTOs);
	}
	
	
	//Buscar por ID
	@GetMapping("/{id}")
	public ResponseEntity<Scheduling> findById(@PathVariable Integer id){
		Scheduling scheduling = service.findByIdService(id);
		return ResponseEntity.ok().body(scheduling);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Scheduling insert(@RequestBody SchedulingNewDTO obj) {
		return service.insertService(obj);
		
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Scheduling Update(@RequestBody SchedulingNewDTO obj, @PathVariable Integer id) {
		return service.updateService(id,obj);
		
	}

}














