package com.stoop.api.service;

import java.util.List;

import com.stoop.api.entities.InOutRegister;

public interface InOutRegisterService {

	List<InOutRegister> findAll();

	void registerInOut(InOutRegister inOutRegister);

	InOutRegister findByCarPlate(String carPlate);

}
