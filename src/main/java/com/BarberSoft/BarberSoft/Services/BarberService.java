package com.BarberSoft.BarberSoft.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.BarberSoft.BarberSoft.Dto.Barber.BarberDTO;
import com.BarberSoft.BarberSoft.Entities.Barber;
import com.BarberSoft.BarberSoft.Repositories.BarberRepository;
import com.BarberSoft.BarberSoft.Services.Exception.ObjectNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class BarberService {
	
	@Autowired
	private BarberRepository repository;
	
	public List<Barber> findAllService(){
		return repository.findAll();
	}
	
	
	public Barber findByIdService(Integer id) {
		Optional<Barber> barber = repository.findById(id);
		
		return barber.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Barber.class.getName()));
	}
	
	@Transactional
	public Barber insertService(Barber obj) {
		try {
			obj.setId(null);
			obj = repository.save(obj);
			
			return obj;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@Transactional
	public Barber updateService(Barber obj) {
		try {
			Barber barber = findByIdService(obj.getId());
			
			upadeteData(barber, obj);
			return repository.save(barber);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	public List<Barber> searchSpecialtyService(String specialty){
		return repository.searchSpecialty("%"+specialty+"%");
	}
	
	public List<Barber> searchSNameService(String name){
		return repository.searchSName("%"+name+"%");
	}
	
	public List<Barber> searchWorkingHoursService(String workingHours){
		return repository.searchSName("%"+workingHours+"%");
	}
	
	public List<Barber> searchCommissionService(String commission){
		return repository.searchCommission("%"+commission+"%");
	}


	private void upadeteData(Barber barber, Barber obj) {
		barber.setName(obj.getName());
		barber.setSpecialty(obj.getSpecialty());
		barber.setCommission(obj.getCommission());
		barber.setWorkingHours(obj.getWorkingHours());
	}
	
	public Barber fromDto(BarberDTO objDto) {
		Barber barber = new Barber(null, objDto.getName(),objDto.getSpecialty(),objDto.getCommission(),objDto.getWorkingHours());
		return barber;
	}

}
