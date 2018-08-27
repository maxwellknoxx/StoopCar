package com.stoop.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoop.api.entities.SeparatedCar;
import com.stoop.api.repository.SeparatedCarRepository;
import com.stoop.api.service.SeparatedCarService;

@Service
public class SeparatedCarServiceImpl implements SeparatedCarService {

	@Autowired
	private SeparatedCarRepository separatedCarRepository;

	@Override
	public SeparatedCar findByCarPlate(String carPlate) {
		SeparatedCar car = separatedCarRepository.findByCarPlate(carPlate);
		return car;
	}

	@Override
	public List<SeparatedCar> findAll() {
		List<SeparatedCar> cars = separatedCarRepository.findAll();
		return cars;
	}

	@Override
	public void registerSeparatedCar(SeparatedCar car) {
		separatedCarRepository.save(car);
	}

	@Override
	public void removeSeparatedCar(Long id) {
		separatedCarRepository.deleteById(id);
	}

}
