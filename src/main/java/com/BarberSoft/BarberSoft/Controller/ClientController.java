package com.BarberSoft.BarberSoft.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.BarberSoft.BarberSoft.Dto.ClientDTO;
import com.BarberSoft.BarberSoft.Entities.Client;
import com.BarberSoft.BarberSoft.Services.CleintService;

@RestController
@RequestMapping(value = "api/client")
public class ClientController {
	
	@Autowired
	private CleintService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClientDTO>> findAll(){
		List<Client> clients = service.findAllService();
		List<ClientDTO> clientDtos = clients.stream().map(obj -> new ClientDTO(obj))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(clientDtos);
	}

}
