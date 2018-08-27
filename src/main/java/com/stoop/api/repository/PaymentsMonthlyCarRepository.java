package com.stoop.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stoop.api.entities.PaymentsMonthlyCar;

@Repository
public interface PaymentsMonthlyCarRepository  extends JpaRepository<PaymentsMonthlyCar, Long>{

	List<PaymentsMonthlyCar> findAll();
	
}
