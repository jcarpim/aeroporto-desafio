package com.desafio.aeroporto.repository;

import java.util.List;

import com.desafio.aeroporto.model.Aeroporto;

public interface AeroportoRepository {
	
	public List<Aeroporto> carregarTodos();

	
}
