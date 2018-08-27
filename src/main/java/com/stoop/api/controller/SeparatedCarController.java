package com.stoop.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stoop.api.dto.SeparatedCarDTO;
import com.stoop.api.entities.SeparatedCar;
import com.stoop.api.response.Response;
import com.stoop.api.service.impl.SeparatedCarServiceImpl;

@RestController
public class SeparatedCarController {

	@Autowired
	private SeparatedCarServiceImpl separatedCarServiceImpl;

	@PostMapping(value = "/api/SCController/register")
	public ResponseEntity<Response<SeparatedCar>> register(@Valid @RequestBody SeparatedCarDTO dto,
			BindingResult result) {
		Response<SeparatedCar> response = new Response<>();
		SeparatedCar entity = new SeparatedCar();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		if (dto.getId() != null) {
			entity.setId(dto.getId());
		}
		entity.setCarPlate(dto.getCarPlate());
		
		separatedCarServiceImpl.registerSeparatedCar(entity);
		
		response.setData(entity);

		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/api/SCController/findAll")
	public ResponseEntity<Response<SeparatedCar>> findAll(@Valid @RequestBody SeparatedCarDTO dto, BindingResult result){
		Response<SeparatedCar> response = new Response<>();
		List<SeparatedCar> entities = new ArrayList<>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		entities = separatedCarServiceImpl.findAll();
		
		response.setListData(entities);
		
		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/api/SCController/findByCarPlate")
	public ResponseEntity<Response<SeparatedCar>> findByCarPlate(@Valid @RequestBody SeparatedCarDTO dto, BindingResult result){
		Response<SeparatedCar> response = new Response<>();
		SeparatedCar entity = new SeparatedCar();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		entity = separatedCarServiceImpl.findByCarPlate(dto.getCarPlate());
		
		response.setData(entity);
		
		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/api/SCController/removeById")
	public ResponseEntity<Response<SeparatedCar>> removeById(@Valid @RequestBody SeparatedCarDTO dto, BindingResult result){
		Response<SeparatedCar> response = new Response<>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		separatedCarServiceImpl.removeSeparatedCar(dto.getId());
		
		return ResponseEntity.ok(response);
		
	}
	
}
