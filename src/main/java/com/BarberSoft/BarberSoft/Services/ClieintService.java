package com.BarberSoft.BarberSoft.Services;

import java.util.List;import org.aspectj.apache.bcel.generic.InstructionConstants.Clinit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.BarberSoft.BarberSoft.Dto.ClientDTO;
import com.BarberSoft.BarberSoft.Entities.Client;
import com.BarberSoft.BarberSoft.Repositories.ClientRepository;

import jakarta.transaction.Transactional;

@Service
public class ClieintService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAllService(){
		return repository.findAll();
	}
	
	
	@Transactional
	public Client insertService(Client obj) {
		try {
			obj.setId(null);
			obj = repository.save(obj);
			
			return obj;
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	public Client fromDto(ClientDTO objDto) {
		Client client = new Client(null, objDto.getName(),objDto.getPhone(), objDto.getEmail(), objDto.getDateOfBirth());
		
		return client;
		
	}

}

