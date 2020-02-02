package com.desafio.aeroporto.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.aeroporto.exception.VooException;
import com.desafio.aeroporto.model.Voo;
import com.desafio.aeroporto.repository.VooRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VooServiceImpl implements VooService {
	@Autowired
	List<VooRepository> voosRepository;

	@Override
	public List<Voo> search(String origem, String destino, LocalDateTime dataVoo) {
		final List<Voo> voos = new ArrayList<Voo>();
		voosRepository.forEach(repository -> {
			try {
				voos.addAll(repository.search(origem, destino, dataVoo));
			} catch (VooException e) {
				e.printStackTrace();
			}
		});
		return voos;
	}

}
