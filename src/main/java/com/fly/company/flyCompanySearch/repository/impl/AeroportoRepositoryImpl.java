package com.fly.company.flyCompanySearch.repository.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.json.GsonJsonParser;

import com.fly.company.flyCompanySearch.model.Aeroporto;
import com.fly.company.flyCompanySearch.repository.AeroportoRepository;

public class AeroportoRepositoryImpl implements AeroportoRepository {

	@Override
	public List<Aeroporto> carregarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<Aeroporto> carregarJson(){
		String json = new String();
		List<Aeroporto> aeroportos = new ArrayList<Aeroporto>();
		
		try {
			json = String.join(" ",
					Files.readAllLines(
							Paths.get("C:" + File.separator + "desafio" + File.separator + "99planes.json"),
							StandardCharsets.UTF_8));
			List<Object> list = new GsonJsonParser().parseList(json);
			list.forEach(aeroporto -> {
				
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aeroportos;
		
	}

}
