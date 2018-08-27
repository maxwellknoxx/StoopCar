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

import com.stoop.api.dto.PaymentsSeparatedCarDTO;
import com.stoop.api.entities.PaymentsSeparatedCar;
import com.stoop.api.response.Response;
import com.stoop.api.service.impl.PaymentsSeparatedCarServiceImpl;

@RestController
public class PaymentsSeparatedCarController {

	private static final Logger log = LoggerFactory.getLogger(PaymentsSeparatedCarController.class);

	@Autowired
	private PaymentsSeparatedCarServiceImpl paymentsSeparatedCarServiceImpl;

	/**
	 * 
	 * @param dto
	 * @param result
	 * @return
	 */
	@PostMapping(value = "/api/PSCController/findAll")
	public ResponseEntity<Response<PaymentsSeparatedCar>> findAll(@Valid @RequestBody PaymentsSeparatedCarDTO dto,
			BindingResult result) {
		Response<PaymentsSeparatedCar> response = new Response<>();
		List<PaymentsSeparatedCar> entity = new ArrayList<>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		try {
			entity = paymentsSeparatedCarServiceImpl.findAll();
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}

		response.setListData(entity);

		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/api/PSCController/registerPayment")
	public ResponseEntity<Response<PaymentsSeparatedCar>> registerPayment(
			@Valid @RequestBody PaymentsSeparatedCarDTO dto, BindingResult result) {
		Response<PaymentsSeparatedCar> response = new Response<>();
		PaymentsSeparatedCar entity = new PaymentsSeparatedCar();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		if (dto.getId() != null) {
			entity.setId(dto.getId());
		}

		entity.setCarPlate(dto.getCarPlate());
		entity.setPricePaid(dto.getPricePaid());
		entity.setTotalHours(dto.getTotalHour());

		try {
			entity = paymentsSeparatedCarServiceImpl.registerPayment(entity);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}

		response.setData(entity);

		return ResponseEntity.ok(response);
	}

}
