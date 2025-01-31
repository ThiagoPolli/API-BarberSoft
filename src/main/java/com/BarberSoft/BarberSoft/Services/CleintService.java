package com.BarberSoft.BarberSoft.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BarberSoft.BarberSoft.Entities.Client;
import com.BarberSoft.BarberSoft.Repositories.ClientRepository;

@Service
public class CleintService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAllService(){
		return repository.findAll();
	}

}
