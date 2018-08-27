package com.stoop.api.service;

import java.util.List;

import com.stoop.api.entities.MonthlyCar;

public interface MonthlyCarService {

	MonthlyCar findByCarPlate(String carPlate);

	List<MonthlyCar> findAll();

	void registerMonthlyCar(MonthlyCar monthlyCar);
	
	void removeMonthlyCar(Long id);

}
