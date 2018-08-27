package com.stoop.api.service;

import java.util.List;

import com.stoop.api.entities.PaymentsSeparatedCar;

public interface PaymentsSeparatedCarService {
	
	List<PaymentsSeparatedCar> findAll();
	
	PaymentsSeparatedCar registerPayment(PaymentsSeparatedCar paymentsSeparatedCar);

}
