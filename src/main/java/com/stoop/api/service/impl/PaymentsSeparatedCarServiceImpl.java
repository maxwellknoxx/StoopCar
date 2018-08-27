package com.stoop.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoop.api.entities.PaymentsSeparatedCar;
import com.stoop.api.repository.PaymentsSeparatedCarRepository;
import com.stoop.api.service.PaymentsSeparatedCarService;

@Service
public class PaymentsSeparatedCarServiceImpl implements PaymentsSeparatedCarService {

	@Autowired
	private PaymentsSeparatedCarRepository paymentsSeparatedCarRepository;

	@Override
	public List<PaymentsSeparatedCar> findAll() {
		List<PaymentsSeparatedCar> payments = paymentsSeparatedCarRepository.findAll();
		return payments;
	}

	@Override
	public PaymentsSeparatedCar registerPayment(PaymentsSeparatedCar paymentsSeparatedCar) {
		return paymentsSeparatedCarRepository.save(paymentsSeparatedCar);
	}

}
