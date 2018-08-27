package com.stoop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.stoop.api.entities.PaymentsMonthlyCar;
import com.stoop.api.entities.PaymentsSeparatedCar;
import com.stoop.api.service.impl.PaymentsMonthlyCarServiceImpl;
import com.stoop.api.service.impl.PaymentsSeparatedCarServiceImpl;

@SpringBootApplication
public class StoopCarApplication {
	
	@Autowired
	private PaymentsMonthlyCarServiceImpl monthly;
	
	@Autowired
	private PaymentsSeparatedCarServiceImpl separated;

	public static void main(String[] args) {
		SpringApplication.run(StoopCarApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			PaymentsSeparatedCar s = new PaymentsSeparatedCar();
			s.setCarPlate("ADS-2016");
			s.setPricePaid("$11,5");
			s.setTotalHours("4:35:25");
			
			separated.registerPayment(s);
			
			PaymentsMonthlyCar m = new PaymentsMonthlyCar();
			m.setCarPlate("KNX-2018");
			m.setPricePaid("$150");
			
			monthly.registerPayment(m);
			
		};
	}
	
}
