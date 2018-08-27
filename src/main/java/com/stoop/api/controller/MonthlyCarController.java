package com.stoop.api.controller;

import java.util.List;

import javax.validation.Valid;

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

	@Autowired
	private MonthlyCarServiceImpl monthlyCarServiceImpl;

	@PostMapping(value = "/api/MCController/findAll")
	public ResponseEntity<Response<MonthlyCar>> findAll(@Valid @RequestBody MonthlyCarDTO dto, BindingResult result) {
		Response<MonthlyCar> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		List<MonthlyCar> entityCars = monthlyCarServiceImpl.findAll();
		
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
		
		entity = monthlyCarServiceImpl.findByCarPlate(dto.getCarPlate());
		
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
		
		monthlyCarServiceImpl.registerMonthlyCar(entity);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/api/MCController/removeMonthlyCar")
	public ResponseEntity<Response<MonthlyCar>> removeMonthlyCar(@Valid @RequestBody MonthlyCarDTO dto, BindingResult result){
		Response<MonthlyCar> response = new Response<>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		monthlyCarServiceImpl.removeMonthlyCar(dto.getId());

		return ResponseEntity.ok(response);
		
	}
	
}
