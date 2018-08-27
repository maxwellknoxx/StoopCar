package com.stoop.api.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stoop.api.dto.InOutRegisterDTO;
import com.stoop.api.entities.InOutRegister;
import com.stoop.api.response.Response;
import com.stoop.api.service.impl.InOutRegisterServiceImpl;
import com.stoop.api.utils.Time;

@RestController
public class InOutRegisterController {

	private static final Logger log = LoggerFactory.getLogger(InOutRegisterServiceImpl.class);

	@Autowired
	private InOutRegisterServiceImpl inOutRegisterImpl;

	final static int ONE_HOUR_SECONDS = 3600;
	final static int ONE_MINUTO_SECONDS = 60;
	final static Double PRICE_PER_HOUR = 2.00;

	@PostMapping(value = "/api/IORController/registerInOut")
	public ResponseEntity<Response<InOutRegister>> registerInOut(@Valid @RequestBody InOutRegisterDTO dto,
			BindingResult result) {
		Response<InOutRegister> response = new Response<>();
		InOutRegister entity = new InOutRegister();
		InOutRegisterDTO responseDTO = new InOutRegisterDTO();
		String totalHours = "";
		String totalToPay;

		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		if (dto.getId() != null) {
			entity.setId(dto.getId());
			entity.setOutHour(nowHour());
		}

		entity.setInHour(nowHour());
		entity.setCarPlate(dto.getCarPlate());

		try {
			inOutRegisterImpl.registerInOut(entity);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}

		if (dto.getId() != null) {
			totalHours = calculateHours(dto.getInHour(), dto.getOutHour());
			totalToPay = calculateTotalPayment(totalHours);

			responseDTO.setCarPlate(dto.getCarPlate());
			responseDTO.setId(dto.getId());
			responseDTO.setInHour(dto.getInHour());
			responseDTO.setOutHour(dto.getOutHour());
			responseDTO.setTotalHours(totalHours);
			responseDTO.setTotalToPay(totalToPay);
			response.setData(entity);
		} else {
			response.setData(entity);
		}

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @return
	 */
	public String nowHour() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	/**
	 * 
	 * @param inHour
	 * @param outHour
	 * @return
	 */
	public String calculateHours(String inHour, String outHour) {
		String inHourSplit[] = inHour.split(":");
		String outHourSplit[] = outHour.split(":");

		Time startHour = new Time(Integer.parseInt(inHourSplit[0]), Integer.parseInt(inHourSplit[1]),
				Integer.parseInt(inHourSplit[2]));
		Time finishHour = new Time(Integer.parseInt(outHourSplit[0]), Integer.parseInt(outHourSplit[1]),
				Integer.parseInt(outHourSplit[2]));
		Time diff = new Time(0, 0, 0);

		diff = Time.difference(startHour, finishHour);

		System.out.println(diff.getHours() + diff.getMinutes() + diff.getSeconds());

		String totalHours = diff.getHours() + ":" + diff.getMinutes() + ":" + diff.getSeconds();

		return totalHours;
	}

	/**
	 * ((h*3600)+(m*60))*(preçoporhr/3600)
	 * 
	 * @param totalHours
	 */
	public String calculateTotalPayment(String totalHours) {
		int h = Integer.parseInt(totalHours.split(":")[0]);
		int m = Integer.parseInt(totalHours.split(":")[1]);

		double hour = h * ONE_HOUR_SECONDS;
		double minute = m * ONE_MINUTO_SECONDS;
		double hourPlusMinutes = hour + minute;
		Double price = (double) PRICE_PER_HOUR / ONE_HOUR_SECONDS;

		System.out.println("Calculo horas h*3600 = " + hour);
		System.out.println("Calculo minutos m*60 = " + minute);
		System.out.println("Calculo horas + minutos = " + hourPlusMinutes);
		System.out.println("Calculo preco 2/3600 = " + price);

		String totalValue = "€" + Double.toString(hourPlusMinutes * price);

		System.out.println("Valor total " + totalValue);
		return totalValue;
	}

}
