package com.desafio.aeroporto.model;

import java.time.LocalDateTime;

import com.desafio.aeroporto.repository.util.MultiDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class PesquisaVooRequest {
	@JsonProperty(value = "origem")
	private String origem;
	@JsonProperty(value = "destino")
	private String destino;
	@JsonProperty(value = "data_voo")
	@JsonDeserialize(using = MultiDateDeserializer.class)
	private LocalDateTime dataVoo;

	public PesquisaVooRequest() {
		super();
	}

	public PesquisaVooRequest(String origem, String destino, LocalDateTime dataVoo) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.dataVoo = dataVoo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public LocalDateTime getDataVoo() {
		return dataVoo;
	}

	public void setDataVoo(LocalDateTime dataVoo) {
		this.dataVoo = dataVoo;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

}
