package com.BarberSoft.BarberSoft.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BarberSoft.BarberSoft.Entities.Product;

@Repository
public interface Productrepository extends JpaRepository<Product, Integer> {

}
