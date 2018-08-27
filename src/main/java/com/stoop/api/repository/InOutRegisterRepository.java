package com.stoop.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stoop.api.entities.InOutRegister;

@Repository
public interface InOutRegisterRepository extends JpaRepository<InOutRegister, Long> {

	List<InOutRegister> findAll();
	
	InOutRegister findByCarPlate(String carPlate);
	

}
