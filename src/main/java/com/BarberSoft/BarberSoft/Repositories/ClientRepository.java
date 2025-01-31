package com.BarberSoft.BarberSoft.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BarberSoft.BarberSoft.Entities.Client;

@Repository
public interface ClientRepository  extends JpaRepository<Client, Integer>{

}
