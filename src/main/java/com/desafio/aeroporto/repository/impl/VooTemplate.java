package com.desafio.aeroporto.repository.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.desafio.aeroporto.model.Voo;

public abstract class VooTemplate {
	public static Long HORAS_MAXIMAS_INTERVALO = 12l;

	public static boolean isRightFly(Voo p, String origem, String destino, LocalDateTime dataVoo) {
		System.out.println("origem: " + origem + " destino:" + destino + " dataVoo:" + dataVoo);
		System.out.println(
				"Voo [origem: " + p.getOrigem() + " destino:" + p.getDestino() + " dataVoo:" + p.getDataSaida() + "]");
		return p.getOrigem().equals(origem) && p.getDestino().equals(destino) && p.getDataSaida().equals(dataVoo);
	}

	public static boolean isScalaFly(Voo p, String origem, String destino, LocalDateTime dataVoo) {
		System.out.println("origem: " + origem + " destino:" + destino + " dataVoo:" + dataVoo);
		System.out.println(
				"Voo [origem: " + p.getOrigem() + " destino:" + p.getDestino() + " dataVoo:" + p.getDataSaida() + "]");
		return (p.getOrigem().equals(origem) || p.getDestino().equals(destino)) && p.getDataSaida().equals(dataVoo);
	}

	public List<Voo> organizaEscala(List<Voo> escalas) {
		List<Voo> escalaOrganizada = new ArrayList<Voo>();
		for (Integer i = 0; i < escalas.size(); i++) {
			Integer nextIndice = i + 1;
			if (nextIndice < escalas.size())
				if (escalas.get(i).getDestino().equals(escalas.get(nextIndice).getOrigem())) {
					if (formatHoraSaidaVoo(escalas.get(i).getSaida()).plusHours(HORAS_MAXIMAS_INTERVALO)
							.isBefore(formatHoraSaidaVoo(escalas.get(nextIndice).getSaida()))) {
						escalaOrganizada.add(escalas.get(i));

					}
				}
		}
		return escalaOrganizada;
	}

	public static LocalDateTime formatSerializeDateVoo(String date) {
		if (date.length() == 10)
			date = date + "T00:00";

		String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		return LocalDateTime.parse(date, formatter);

	}

	public static LocalTime formatHoraSaidaVoo(String saida) {
		String HORA_FORMAT = "HH:mm";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(HORA_FORMAT);
		return LocalTime.parse(saida, formatter);
	}
}
