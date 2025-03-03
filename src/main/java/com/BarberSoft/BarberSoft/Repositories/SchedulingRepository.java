package com.BarberSoft.BarberSoft.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BarberSoft.BarberSoft.Entities.Scheduling;


@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Integer> {

}
