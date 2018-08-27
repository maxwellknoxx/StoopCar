package com.stoop.api.controller;

import java.util.ArrayList;
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

import com.stoop.api.dto.SeparatedCarDTO;
import com.stoop.api.entities.SeparatedCar;
import com.stoop.api.response.Response;
import com.stoop.api.service.impl.SeparatedCarServiceImpl;

@RestController
public class SeparatedCarController {

	private static final Logger log = LoggerFactory.getLogger(SeparatedCarController.class);

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

		try {
			separatedCarServiceImpl.registerSeparatedCar(entity);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}

		response.setData(entity);

		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/api/SCController/findAll")
	public ResponseEntity<Response<SeparatedCar>> findAll(@Valid @RequestBody SeparatedCarDTO dto,
			BindingResult result) {
		Response<SeparatedCar> response = new Response<>();
		List<SeparatedCar> entities = new ArrayList<>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		try {
			entities = separatedCarServiceImpl.findAll();
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}

		response.setListData(entities);

		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/api/SCController/findByCarPlate")
	public ResponseEntity<Response<SeparatedCar>> findByCarPlate(@Valid @RequestBody SeparatedCarDTO dto,
			BindingResult result) {
		Response<SeparatedCar> response = new Response<>();
		SeparatedCar entity = new SeparatedCar();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		try {
			entity = separatedCarServiceImpl.findByCarPlate(dto.getCarPlate());
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}

		response.setData(entity);

		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/api/SCController/removeById")
	public ResponseEntity<Response<SeparatedCar>> removeById(@Valid @RequestBody SeparatedCarDTO dto,
			BindingResult result) {
		Response<SeparatedCar> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		try {
			separatedCarServiceImpl.removeSeparatedCar(dto.getId());
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.ok(response);

	}

}
