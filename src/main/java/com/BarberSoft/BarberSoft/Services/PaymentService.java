package com.BarberSoft.BarberSoft.Services;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BarberSoft.BarberSoft.Dto.Payment.PaymentDTO;
import com.BarberSoft.BarberSoft.Dto.Payment.PaymentNewDTO;
import com.BarberSoft.BarberSoft.Entities.Payment;
import com.BarberSoft.BarberSoft.Entities.Scheduling;
import com.BarberSoft.BarberSoft.Repositories.PaymentRepository;
import com.BarberSoft.BarberSoft.Services.Exception.ObjectNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repository;
	
	@Autowired 
	private SchedulingService service;
	
	
	public List<Payment> findAllService(){
		return repository.findAll();
	}
	
//	public Payment findByIdService(Integer id) {
//		Optional<Payment> payment = repository.findById(id);
//		return payment.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+ ", Tipo: "+ Payment.class.getName()));
//		
//	}
	
	public PaymentDTO findByIdService(Integer id) {
		Optional<Payment> payment = repository.findById(id);
		
		Payment entity = payment.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+ ", Tipo: "+ Payment.class.getName()));
		
		return new PaymentDTO(entity);
	}
	
	
	@Transactional
	public Payment insertService(PaymentNewDTO obj) {
		Payment payment = new Payment();
		
		Scheduling scheduling = service.findById(obj.getScheduling_id());
		
		obj.setId(null);
		
		
		payment.setValuePayment(obj.getValuePayment());
		payment.setPaymentMethod(obj.getPaymentMethod());
		payment.setTimePayment(LocalDateTime.now());
		payment.setScheduling(scheduling);
		
		return repository.save(payment);
	}

}




