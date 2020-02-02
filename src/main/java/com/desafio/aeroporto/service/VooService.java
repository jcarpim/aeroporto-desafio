package com.desafio.aeroporto.service;

import java.time.LocalDateTime;
import java.util.List;

import com.desafio.aeroporto.model.Voo;


public interface VooService {

	List<Voo> search(String origem, String destino, LocalDateTime dataVoo);
}
