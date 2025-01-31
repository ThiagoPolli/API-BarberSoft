package com.BarberSoft.BarberSoft.Controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.BarberSoft.BarberSoft.Dto.ClientDTO;
import com.BarberSoft.BarberSoft.Entities.Client;
import com.BarberSoft.BarberSoft.Services.ClieintService;

@RestController
@RequestMapping(value = "api/client")
public class ClientController {
	
	@Autowired
	private ClieintService service;
	
	
	//Listar todos os Clientes
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClientDTO>> findAll(){
		List<Client> clients = service.findAllService();
		List<ClientDTO> clientDtos = clients.stream().map(obj -> new ClientDTO(obj))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(clientDtos);
	}
	
	
	//Inserir Novo Cliente
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ClientDTO dto){
		Client client = service.fromDto(dto);
		client = service.insertService(client);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	

}
