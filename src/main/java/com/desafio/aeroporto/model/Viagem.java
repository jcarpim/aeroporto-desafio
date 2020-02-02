package com.desafio.aeroporto.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Viagem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String origem;
	private String destino;
	private LocalDateTime saida;
	private LocalDateTime chegada;
	private List<Voo> trechos;

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public LocalDateTime getChegada() {
		return chegada;
	}

	public void setChegada(LocalDateTime chegada) {
		this.chegada = chegada;
	}

	public List<Voo> getTrechos() {
		return trechos;
	}

	public void setTrechos(List<Voo> trechos) {
		this.trechos = trechos;
	}

	public Viagem(String origem, String destino, LocalDateTime saida, LocalDateTime chegada, List<Voo> trechos) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.saida = saida;
		this.chegada = chegada;
		this.trechos = trechos;
	}

	public Viagem() {
		super();
	}


}
