package com.desafio.aeroporto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.aeroporto.model.Aeroporto;
import com.desafio.aeroporto.repository.AeroportoRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class AeroportoServiceImpl implements AeroportoService {
	@Autowired
	 AeroportoRepository aeroportoRepository;
	
	@Override
	public List<Aeroporto> carregarTodos(){
		return aeroportoRepository.carregarTodos();
	}

}