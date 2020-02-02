package com.desafio.aeroporto.repository.impl;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.desafio.aeroporto.enums.Operadora;
import com.desafio.aeroporto.exception.VooException;
import com.desafio.aeroporto.model.Voo;
import com.desafio.aeroporto.repository.VooRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Repository
public class VooUberRepositoryImpl extends VooTemplate implements VooRepository {

	@Override
	public List<Voo> search(String origem, String destino, LocalDateTime dataVoo) throws VooException {
		final List<Voo> escalasOrganizadas = new ArrayList<Voo>();
		List<Voo> voos = carregarListaVoos();

		List<Voo> escalas = voos.stream().filter(voo -> isScalaFly(voo, origem, destino, dataVoo))
				.collect(Collectors.toList());

		List<Voo> voosUnicos = voos.stream().filter(voo -> isRightFly(voo, origem, destino, dataVoo))
				.collect(Collectors.toList());
		escalasOrganizadas.addAll(organizaEscala(escalas));

		return escalasOrganizadas.size() == 0 ? voosUnicos : escalasOrganizadas;

	}

	private List<Voo> carregarListaVoos() throws VooException {
		List<Voo> flyies = new ArrayList<Voo>();
		try {

			Reader reader = Files.newBufferedReader(
					Paths.get("C:" + File.separator + "desafio" + File.separator + "uberair.csv"));

			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

			List<String[]> linhas = csvReader.readAll();

			linhas.forEach(it -> flyies.add(new Voo(it[0], it[1], it[2], formatSerializeDateVoo(it[3]), it[4], it[5],
					Double.valueOf(it[6]), Operadora.UBER.getLabel())));
		} catch (Exception e) {
			throw new VooException(e.getMessage(), e.getCause());
		}
		return flyies;
	}

}
