package com.desafio.aeroporto.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.desafio.aeroporto.exception.VooException;
import com.desafio.aeroporto.model.Voo;

public interface VooRepository {
	 
	public List<Voo> search(String origem, String  destino,LocalDateTime dataVoo) throws VooException;
}
