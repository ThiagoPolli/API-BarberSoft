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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.BarberSoft.BarberSoft.Dto.ProductDTO;
import com.BarberSoft.BarberSoft.Entities.Product;
import com.BarberSoft.BarberSoft.Services.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "api/product")
@Tag(name = "Product", description = "Product APIs")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	//Listar todos os Produtos
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> findAll(){
		List<Product> products = service.findAllService();
		List<ProductDTO> productDTOs = products.stream().map(obj -> new ProductDTO(obj))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(productDTOs);
	}
	
	
	//Buscar por ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> findById(@PathVariable Integer id){
		Product product = service.findByIdService(id);
		return ResponseEntity.ok().body(product);
	}
	
	//Atualizar
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> update(@RequestBody ProductDTO dto,@PathVariable Integer id){
		Product product = service.fromDto(dto);
		product.setId(id);
		product = service.updateService(product);
		return ResponseEntity.noContent().build();
	}
	
	//Inserir um novo registro
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ProductDTO dto){
		Product product = service.fromDto(dto);
		System.out.println(dto);
		product = service.insertService(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
