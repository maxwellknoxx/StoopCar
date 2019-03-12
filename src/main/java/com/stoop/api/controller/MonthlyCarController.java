package com.stoop.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stoop.api.dto.MonthlyCarDTO;
import com.stoop.api.entities.MonthlyCar;
import com.stoop.api.response.Response;
import com.stoop.api.service.impl.MonthlyCarServiceImpl;

@Scope(value = "session")
@Component(value = "monthlyCarController")
@ELBeanName(value = "monthlyCarController")
@Join(path = "/managementMonthlyCar.jsf", to = "/managementMonthlyCar.jsf")
public class MonthlyCarController {

	private static final Logger log = LoggerFactory.getLogger(MonthlyCarController.class);

	@Autowired
	private MonthlyCarServiceImpl monthlyCarServiceImpl;

	private List<MonthlyCar> listMonthlyCar;

	private MonthlyCar monthlyCar = new MonthlyCar();

	public MonthlyCar getMonthlyCar() {
		return monthlyCar;
	}

	public void setMonthlyCar(MonthlyCar monthlyCar) {
		this.monthlyCar = monthlyCar;
	}

	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		listMonthlyCar = monthlyCarServiceImpl.findAll();
	}

	public List<MonthlyCar> getMonthlyCars() {
		return listMonthlyCar;
	}
	
	public String registerCar() {
		monthlyCarServiceImpl.registerMonthlyCar(monthlyCar);
		this.monthlyCar =  new MonthlyCar();
		return "managementMonthlyCar.xhtml?faces-redirect=true";
	}
	
	public String removeRegister(MonthlyCar monthlyCar){
		monthlyCarServiceImpl.removeMonthlyCar(monthlyCar.getId());
		return "managementMonthlyCar.xhtml?faces-redirect=true";
	}

	public MonthlyCar updateInformation(MonthlyCar monthlyCar) {
		return this.monthlyCar = monthlyCar;
	}
	
	public List<MonthlyCar> getAllCars(){
		return monthlyCarServiceImpl.findAll();
	}
	
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
	public ResponseEntity<Response<MonthlyCar>> findByCarPlate(@Valid @RequestBody MonthlyCarDTO dto,
			BindingResult result) {
		Response<MonthlyCar> response = new Response<>();
		MonthlyCar entity = new MonthlyCar();

		if (result.hasErrors()) {
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
	public ResponseEntity<Response<MonthlyCar>> registerMonthlyCar(@Valid @RequestBody MonthlyCarDTO dto,
			BindingResult result) {
		Response<MonthlyCar> response = new Response<>();
		MonthlyCar entity = new MonthlyCar();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		if (dto.getId() != null) {
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
	public ResponseEntity<Response<MonthlyCar>> removeMonthlyCar(@Valid @RequestBody MonthlyCarDTO dto,
			BindingResult result) {
		Response<MonthlyCar> response = new Response<>();

		if (result.hasErrors()) {
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
