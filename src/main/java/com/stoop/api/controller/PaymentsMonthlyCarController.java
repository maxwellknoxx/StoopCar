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

import com.stoop.api.dto.PaymentsMonthlyCarDTO;
import com.stoop.api.entities.PaymentsMonthlyCar;
import com.stoop.api.response.Response;
import com.stoop.api.service.impl.PaymentsMonthlyCarServiceImpl;

@RestController
public class PaymentsMonthlyCarController {

	private static final Logger log = LoggerFactory.getLogger(PaymentsMonthlyCarController.class);

	@Autowired
	private PaymentsMonthlyCarServiceImpl paymentsMonthlyCarServiceImpl;

	/**
	 * 
	 * @param dto
	 * @param result
	 * @return
	 */
	@PostMapping(value = "/api/PMCController/findAll")
	public ResponseEntity<Response<PaymentsMonthlyCar>> findAll(@Valid @RequestBody PaymentsMonthlyCarDTO dto,
			BindingResult result) {
		Response<PaymentsMonthlyCar> response = new Response<>();
		List<PaymentsMonthlyCar> entities = new ArrayList<>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		try {
			entities = paymentsMonthlyCarServiceImpl.findAll();
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}

		response.setListData(entities);

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param dto
	 * @param result
	 * @return
	 */
	@PostMapping(value = "/api/PMCController/registerPayment")
	public ResponseEntity<Response<PaymentsMonthlyCar>> registerPayment(@Valid @RequestBody PaymentsMonthlyCarDTO dto,
			BindingResult result) {
		Response<PaymentsMonthlyCar> response = new Response<>();
		PaymentsMonthlyCar entity = new PaymentsMonthlyCar();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		if (dto.getId() != null) {
			entity.setId(dto.getId());
		}

		entity.setCarPlate(dto.getCarPlate());
		entity.setPricePaid(dto.getPricePaid());

		try {
			paymentsMonthlyCarServiceImpl.registerPayment(entity);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}

		response.setData(entity);

		return ResponseEntity.ok(response);
	}

}
