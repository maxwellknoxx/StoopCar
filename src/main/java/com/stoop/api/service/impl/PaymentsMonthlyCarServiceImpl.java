package com.stoop.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoop.api.entities.PaymentsMonthlyCar;
import com.stoop.api.repository.PaymentsMonthlyCarRepository;
import com.stoop.api.service.PaymentsMonthlyCarService;

@Service
public class PaymentsMonthlyCarServiceImpl implements PaymentsMonthlyCarService {

	@Autowired
	private PaymentsMonthlyCarRepository paymentsMonthlyCarRepository;

	@Override
	public List<PaymentsMonthlyCar> findAll() {
		List<PaymentsMonthlyCar> payments = paymentsMonthlyCarRepository.findAll();
		return payments;
	}

	@Override
	public PaymentsMonthlyCar registerPayment(PaymentsMonthlyCar paymentsMonthlyCar) {
		return paymentsMonthlyCarRepository.save(paymentsMonthlyCar);
	}

}
