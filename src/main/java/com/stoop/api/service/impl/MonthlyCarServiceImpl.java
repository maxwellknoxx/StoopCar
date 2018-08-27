package com.stoop.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoop.api.entities.MonthlyCar;
import com.stoop.api.repository.MonthlyCarRepository;
import com.stoop.api.service.MonthlyCarService;

@Service
public class MonthlyCarServiceImpl implements MonthlyCarService {

	@Autowired
	private MonthlyCarRepository monthlyCarRepository;

	@Override
	public MonthlyCar findByCarPlate(String carPlate) {
		MonthlyCar car = monthlyCarRepository.findByCarPlate(carPlate);
		return car;
	}

	@Override
	public List<MonthlyCar> findAll() {
		List<MonthlyCar> cars = monthlyCarRepository.findAll();
		return cars;
	}

	@Override
	public void registerMonthlyCar(MonthlyCar monthlyCar) {
		monthlyCarRepository.save(monthlyCar);
	}

	@Override
	public void removeMonthlyCar(Long id) {
		monthlyCarRepository.deleteById(id);
	}

}
