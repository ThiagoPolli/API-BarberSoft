package com.BarberSoft.BarberSoft.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BarberSoft.BarberSoft.Entities.Barber;

@Repository
public interface BarberRepository extends JpaRepository<Barber, Integer>{

}
