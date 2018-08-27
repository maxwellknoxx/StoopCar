package com.stoop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoop.api.entities.MonthlyCar;

public interface MonthlyCarRepository extends JpaRepository<MonthlyCar, Long> {

	MonthlyCar findByCarPlate(String carPlate);
	
}
