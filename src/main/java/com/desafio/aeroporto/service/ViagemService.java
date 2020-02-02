package com.desafio.aeroporto.service;

import java.time.LocalDateTime;

import com.desafio.aeroporto.model.Viagem;


public interface ViagemService {

	Viagem procurar(String origem, String destino, LocalDateTime dataVoo);
}