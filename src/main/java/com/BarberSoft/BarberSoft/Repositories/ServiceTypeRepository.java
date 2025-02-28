package com.BarberSoft.BarberSoft.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BarberSoft.BarberSoft.Entities.ServiceType;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer>{

}
