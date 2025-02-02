package com.BarberSoft.BarberSoft.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BarberSoft.BarberSoft.Entities.Client;

import jakarta.transaction.Transactional;

@Repository
public interface ClientRepository  extends JpaRepository<Client, Integer>{
	
	@Transactional
	@Query(value = "select * from Client where name like UPPER ( :name ) ORDER BY name ", nativeQuery = true )
	public List<Client> searchName(@Param("name") String name);
	
	@Transactional
	@Query(value = "select * from Client where phone like UPPER ( :phone ) ORDER BY phone ", nativeQuery = true )
	public Client searchPhone(@Param("phone") String phone);

}
