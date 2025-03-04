package com.BarberSoft.BarberSoft.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.BarberSoft.BarberSoft.Dto.Product.ProductDTO;
import com.BarberSoft.BarberSoft.Entities.Product;
import com.BarberSoft.BarberSoft.Repositories.Productrepository;
import com.BarberSoft.BarberSoft.Services.Exception.ObjectNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	@Autowired
	private Productrepository repository;
	
	
	public List<Product> findAllService(){
		return repository.findAll();
	}
	
	public Product findByIdService(Integer id) {
		Optional<Product> product = repository.findById(id);
		return product.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+ ", Tipo: "+ Product.class.getName()));
	}
	
	@Transactional
	public Product insertService(Product obj) {
		try {
			LocalDateTime data = LocalDateTime.now();
			obj.setId(null);
			obj.setCreatAtUpdate(data);
			obj = repository.save(obj);
			
			return obj;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Transactional
	public Product updateService(Product obj) {
		try {
			Product product = findByIdService(obj.getId());
			updateData(product, obj);
			return repository.save(product);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	private void updateData(Product product, Product obj) {
		LocalDateTime data = LocalDateTime.now();
		product.setName(obj.getName());
		product.setPrice(obj.getPrice());
		product.setQtd(obj.getQtd());
		product.setCreatAtUpdate(data);
		
	}
	public Product fromDto(ProductDTO objDto) {
		Product product = new Product(null, objDto.getName(), objDto.getPrice(), objDto.getQtd(), objDto.getCreatAtUpdate());
		return product;
	}


}