package com.stoop.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoop.api.entities.InOutRegister;
import com.stoop.api.repository.InOutRegisterRepository;
import com.stoop.api.service.InOutRegisterService;

@Service
public class InOutRegisterServiceImpl implements InOutRegisterService {

	@Autowired
	private InOutRegisterRepository inOutRegisterRepository;

	@Override
	public List<InOutRegister> findAll() {
		List<InOutRegister> inOutRegister = null;
		inOutRegister = inOutRegisterRepository.findAll();
		return inOutRegister;
	}

	@Override
	public void registerInOut(InOutRegister inOutRegister) {
		inOutRegisterRepository.save(inOutRegister);
	}

	@Override
	public InOutRegister findByCarPlate(String carPlate) {
		InOutRegister inOutRegister = inOutRegisterRepository.findByCarPlate(carPlate);
		return inOutRegister;
	}

}
