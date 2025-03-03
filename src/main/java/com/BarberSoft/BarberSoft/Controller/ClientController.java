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

import com.BarberSoft.BarberSoft.Dto.Client.ClientDTO;
import com.BarberSoft.BarberSoft.Entities.Client;
import com.BarberSoft.BarberSoft.Services.ClieintService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "api/client")
@Tag(name = "Client", description = "Client APIs")
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
	
	//Buscar por ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> findById (@PathVariable Integer id) {
		Client client = service.findByIdService(id);
		return ResponseEntity.ok().body(client);
	}
	
	//Listar por nomes
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> search(@RequestParam(value = "name", defaultValue = "") String name){
	
		List<Client> client = service.searchNameService(name);
		return ResponseEntity.ok().body(client);
	}
	
	//Buscar por telefone
	@RequestMapping(value = "/searchPhone", method = RequestMethod.GET)
	public ResponseEntity<Client> findByPhone(@RequestParam(value = "phone", defaultValue = "") String phone){
		Client client = service.searchPhoneService(phone);
		return ResponseEntity.ok().body(client);
	}
	
	//Atualizar 
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Client> update(@RequestBody @Valid ClientDTO dto, @PathVariable Integer id){
		Client client = service.fromDto(dto);
		client.setId(id);
		client = service.updateService(client);
		return ResponseEntity.noContent().build();
	}
	
	//Inserir Novo Cliente
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody @Valid ClientDTO dto){
		Client client = service.fromDto(dto);
		client = service.insertService(client);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	

}
