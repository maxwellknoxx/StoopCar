package com.stoop.api.testsClasses;

public class TestHour {

	public static void main(String args[]) {
		
		
		//((h*3600)+(m*60))*(preçoporhr/3600)
			int h = 5;
			int m = 45;
			
			double hour = h*3600;
			double minute = m*60;
			double hourPlusMinutes = hour + minute;
			Double price = (double) 2/3600;
			
			
			System.out.println("Calculo horas h*3600 = " + hour);
			System.out.println("Calculo minutos m*60 = " + minute);
			System.out.println("Calculo horas + minutos = " + hourPlusMinutes);
			System.out.println("Calculo preco 2/3600 = " + price);
			
			String totalFull = "$" + Double.toString(hourPlusMinutes * price);
			
			System.out.println("Valor total " + totalFull);


	}

}
