package com.BarberSoft.BarberSoft.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.BarberSoft.BarberSoft.Dto.Client.ClientDTO;
import com.BarberSoft.BarberSoft.Entities.Client;
import com.BarberSoft.BarberSoft.Repositories.ClientRepository;
import com.BarberSoft.BarberSoft.Services.Exception.ObjectNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ClieintService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAllService(){
		return repository.findAll();
	}
	
	public Client findByIdService(Integer id) {
		Optional<Client> client = repository.findById(id);
		
		return client.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
	}
	
	public List<Client> searchNameService(String name){
		return repository.searchName("%"+name+"%");
	}
	
	public Client searchPhoneService(String phone) {
		Client client = repository.searchPhone(phone);
		
		return client;
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
	
	@Transactional
	public Client updateService(Client obj) {
		try {
			Client client = findByIdService(obj.getId());
			updateData(client, obj);
			return repository.save(client);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	private void updateData(Client client, Client obj) {
		client.setName(obj.getName());
		client.setPhone(obj.getPhone());
		client.setEmail(obj.getEmail());
		client.setDateOfBirth(obj.getDateOfBirth());
	}

	public Client fromDto(ClientDTO objDto) {
		Client client = new Client(null, objDto.getName(),objDto.getPhone(), objDto.getEmail(), objDto.getDateOfBirth());
		
		return client;
		
	}

}

