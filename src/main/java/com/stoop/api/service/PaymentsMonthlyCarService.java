package com.stoop.api.service;

import java.util.List;

import com.stoop.api.entities.PaymentsMonthlyCar;

public interface PaymentsMonthlyCarService {

	List<PaymentsMonthlyCar> findAll();

	PaymentsMonthlyCar registerPayment(PaymentsMonthlyCar paymentsMonthlyCar);

}
