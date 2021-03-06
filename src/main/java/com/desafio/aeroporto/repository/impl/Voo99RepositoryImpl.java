package com.desafio.aeroporto.repository.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Repository;

import com.desafio.aeroporto.enums.Operadora;
import com.desafio.aeroporto.exception.VooException;
import com.desafio.aeroporto.model.Voo;
import com.desafio.aeroporto.repository.VooRepository;
import com.google.gson.internal.LinkedTreeMap;
@Repository
public class Voo99RepositoryImpl extends VooTemplate implements VooRepository {

	private List<Voo> carregarListaVoo() throws VooException {
		String json;
		List<Voo> voos = new ArrayList<Voo>();
		try {
			json = String.join(" ",
					Files.readAllLines(
							Paths.get("C:" + File.separator + "desafio" + File.separator + "99planes.json"),
							StandardCharsets.UTF_8));
			List<Object> list = new GsonJsonParser().parseList(json);
			list.forEach(it -> {
				LinkedTreeMap<String, Object> linha = (LinkedTreeMap<String, Object>) it;
				Double valor = (Double) linha.get("valor");
				voos.add(new Voo(linha.get("voo").toString(), linha.get("origem").toString(),
						linha.get("destino").toString(), formatSerializeDateVoo(linha.get("data_saida").toString()),
						linha.get("saida").toString(), linha.get("chegada").toString(), valor,
						Operadora.NOVE_NOVE.getLabel()));

			});
		} catch (IOException e) {
			throw new VooException(e.getMessage(), e.getCause());
		}
		return voos;
	}

	@Override
	public List<Voo> search(String origem, String destino, LocalDateTime dataVoo) throws VooException {
		final List<Voo> escalasOrganizadas = new ArrayList<Voo>();
		List<Voo> voos = carregarListaVoo();

		List<Voo> escalas = voos.stream().filter(voo -> isScalaFly(voo, origem, destino, dataVoo))
				.collect(Collectors.toList());

		List<Voo> voosUnicos = voos.stream().filter(voo -> isRightFly(voo, origem, destino, dataVoo))
				.collect(Collectors.toList());
		escalasOrganizadas.addAll(organizaEscala(escalas));

		return escalasOrganizadas.size() == 0 ? voosUnicos : escalasOrganizadas;
	}

}
