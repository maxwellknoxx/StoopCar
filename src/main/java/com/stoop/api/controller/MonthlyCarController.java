package com.stoop.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stoop.api.dto.MonthlyCarDTO;
import com.stoop.api.entities.MonthlyCar;
import com.stoop.api.response.Response;
import com.stoop.api.service.impl.MonthlyCarServiceImpl;

@RestController
public class MonthlyCarController {
	
	private static final Logger log = LoggerFactory.getLogger(MonthlyCarController.class);

	@Autowired
	private MonthlyCarServiceImpl monthlyCarServiceImpl;

	@PostMapping(value = "/api/MCController/findAll")
	public ResponseEntity<Response<MonthlyCar>> findAll(@Valid @RequestBody MonthlyCarDTO dto, BindingResult result) {
		Response<MonthlyCar> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		List<MonthlyCar> entityCars = null;
		try {
			entityCars = monthlyCarServiceImpl.findAll();
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		
		response.setListData(entityCars);

		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/api/MCController/findByCarPlate")
	public ResponseEntity<Response<MonthlyCar>> findByCarPlate(@Valid @RequestBody MonthlyCarDTO dto, BindingResult result){
		Response<MonthlyCar> response = new Response<>();
		MonthlyCar entity = new MonthlyCar();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		try {
			entity = monthlyCarServiceImpl.findByCarPlate(dto.getCarPlate());
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		
		response.setData(entity);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/api/MCController/register")
	public ResponseEntity<Response<MonthlyCar>> registerMonthlyCar(@Valid @RequestBody MonthlyCarDTO dto, BindingResult result ){
		Response<MonthlyCar> response = new Response<>();
		MonthlyCar entity = new MonthlyCar();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		if(dto.getId() != null) {
			entity.setId(dto.getId());
		}
		entity.setBrand(dto.getBrand());
		entity.setModel(dto.getModel());
		entity.setCarPlate(dto.getCarPlate());
		entity.setOwner(dto.getOwner());
		
		try {
			monthlyCarServiceImpl.registerMonthlyCar(entity);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/api/MCController/removeMonthlyCar")
	public ResponseEntity<Response<MonthlyCar>> removeMonthlyCar(@Valid @RequestBody MonthlyCarDTO dto, BindingResult result){
		Response<MonthlyCar> response = new Response<>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		try {
			monthlyCarServiceImpl.removeMonthlyCar(dto.getId());
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.ok(response);
		
	}
	
}
