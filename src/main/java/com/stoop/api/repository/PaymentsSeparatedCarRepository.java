package com.stoop.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stoop.api.entities.PaymentsSeparatedCar;

@Repository
public interface PaymentsSeparatedCarRepository extends JpaRepository<PaymentsSeparatedCar, Long> {

	List<PaymentsSeparatedCar> findAll();

}
