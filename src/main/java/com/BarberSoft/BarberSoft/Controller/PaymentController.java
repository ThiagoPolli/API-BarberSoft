package com.BarberSoft.BarberSoft.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.BarberSoft.BarberSoft.Dto.Payment.PaymentDTO;
import com.BarberSoft.BarberSoft.Dto.Payment.PaymentNewDTO;
import com.BarberSoft.BarberSoft.Entities.Payment;
import com.BarberSoft.BarberSoft.Services.PaymentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "api/payment")
@Tag(name = "Payment", description = "Payment APIs")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping
	public ResponseEntity<List<PaymentDTO>> findAll() {
		List<Payment> payments = service.findAllService();
		List<PaymentDTO> payDtos =  payments.stream().map(obj -> new PaymentDTO(obj))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(payDtos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaymentDTO> findById(@PathVariable Integer id) {
		 PaymentDTO payments = service.findByIdService(id);
		return ResponseEntity.ok().body(payments);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Payment insert(@RequestBody PaymentNewDTO obj) {
		return service.insertService(obj);
		
	}

}