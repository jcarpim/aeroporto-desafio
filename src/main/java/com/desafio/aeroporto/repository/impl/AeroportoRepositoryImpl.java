package com.desafio.aeroporto.repository.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Repository;

import com.desafio.aeroporto.model.Aeroporto;
import com.desafio.aeroporto.repository.AeroportoRepository;
import com.google.gson.internal.LinkedTreeMap;

@Repository
public class AeroportoRepositoryImpl implements AeroportoRepository {

	@Override
	public List<Aeroporto> carregarTodos() {
		return carregarJson();
	}

	private List<Aeroporto> carregarJson() {
		String json = new String();
		List<Aeroporto> aeroportos = new ArrayList<Aeroporto>();

		try {
			json = String.join(" ",
					Files.readAllLines(Paths.get("C:" + File.separator + "desafio" + File.separator + "aeroportos.json"),
							StandardCharsets.UTF_8));
			List<Object> list = new GsonJsonParser().parseList(json);
			list.forEach(aeroporto -> {
				LinkedTreeMap<String, Object> linha = (LinkedTreeMap<String, Object>) aeroporto;

				aeroportos.add(new Aeroporto(linha.get("nome").toString(), linha.get("aeroporto").toString(),
						linha.get("cidade").toString()));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aeroportos;

	}

}