package com.stoop.api.service;

import java.util.List;

import com.stoop.api.entities.SeparatedCar;

public interface SeparatedCarService {

	SeparatedCar findByCarPlate(String carPlate);

	List<SeparatedCar> findAll();

	void registerSeparatedCar(SeparatedCar car);

	void removeSeparatedCar(Long id);

}
