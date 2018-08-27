package com.stoop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stoop.api.entities.SeparatedCar;

@Repository
public interface SeparatedCarRepository extends JpaRepository<SeparatedCar, Long>{

	SeparatedCar findByCarPlate(String carPlate);
	
}
