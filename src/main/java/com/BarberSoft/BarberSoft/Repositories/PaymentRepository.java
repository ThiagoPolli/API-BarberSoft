package com.BarberSoft.BarberSoft.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BarberSoft.BarberSoft.Entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
