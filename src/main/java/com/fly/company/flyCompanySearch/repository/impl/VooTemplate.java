package com.fly.company.flyCompanySearch.repository.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fly.company.flyCompanySearch.model.Voo;

public abstract class VooTemplate {

	public static boolean isRightFly(Voo p, String origem, String destino, LocalDateTime dataVoo) {
		System.out.println("origem: " + origem + " destino:" + destino + " dataVoo:" + dataVoo);
		System.out.println(
				"Voo [origem: " + p.getOrigem() + " destino:" + p.getDestino() + " dataVoo:" + p.getDataSaida() + "]");
		return p.getOrigem().equals(origem) && p.getDestino().equals(destino) && p.getDataSaida().equals(dataVoo);
	}

	public static LocalDateTime formatSerializeDateVoo(String date) {
		if (date.length() == 10)
			date = date + "T00:00";
    
		String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		return LocalDateTime.parse(date, formatter);

	}
	
}
