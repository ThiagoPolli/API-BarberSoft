package com.BarberSoft.BarberSoft.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BarberSoft.BarberSoft.Entities.Barber;

import jakarta.transaction.Transactional;

@Repository
public interface BarberRepository extends JpaRepository<Barber, Integer>{
	
	@Transactional
	@Query(value = "select * from Barber where specialty like UPPER ( :specialty ) ", nativeQuery = true)
	public List<Barber> searchSpecialty(@Param("specialty") String specialty);
	
	@Transactional
	@Query(value = "select * from Barber where name like UPPER ( :name ) ", nativeQuery = true)
	public List<Barber> searchSName(@Param("name") String specialty);
	
	@Transactional
	@Query(value = "select * from Barber where workingHours like UPPER ( :workingHours ) ", nativeQuery = true)
	public List<Barber> searchWorkingHours(@Param("workingHours") String specialty);

}
