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

import com.stoop.api.dto.SpacesDTO;
import com.stoop.api.entities.Spaces;
import com.stoop.api.repository.SpacesRepository;
import com.stoop.api.response.Response;

@RestController
public class SpacesController {

	@Autowired
	private SpacesRepository spacesRepository;

	@PostMapping(value = "/api/SController/findAll")
	public ResponseEntity<Response<Spaces>> findAll(@Valid @RequestBody SpacesDTO dto, BindingResult result) {
		Response<Spaces> response = new Response<>();
		List<Spaces> entities = new ArrayList<>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		entities = spacesRepository.findAll();

		response.setListData(entities);

		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/api/SController/update")
	public ResponseEntity<Response<Spaces>> update(@Valid @RequestBody SpacesDTO dto, BindingResult result){
		Response<Spaces> response = new Response<>();
		Spaces entity = new Spaces();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		if(dto.getId() != null) {
			entity.setId(dto.getId());
		}
		entity.setTotal(dto.getTotal());
		entity.setEmpty(dto.getEmpty());
		entity.setBusy(dto.getBusy());
		entity = spacesRepository.save(entity);
		
		response.setData(entity);
		
		return ResponseEntity.ok(response);
	}
	
}
