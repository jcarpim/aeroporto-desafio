package com.desafio.aeroporto.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Voo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String voo;

	private String origem;
	private String destino;
	private LocalDateTime dataSaida;
	private String saida;
	private String chegada;
	private Double valor;

	public Voo() {
	}

	public Voo(String voo, String origem, String destino, LocalDateTime dataSaida, String saida, String chegada,
			Double valor) {
		super();
		this.voo = voo;
		this.origem = origem;
		this.destino = destino;
		this.dataSaida = dataSaida;
		this.saida = saida;
		this.chegada = chegada;
		this.valor = valor;
		System.out.println(toString());
	}

	public String getVoo() {
		return voo;
	}

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public String getSaida() {
		return saida;
	}

	public String getChegada() {
		return chegada;
	}

	public Double getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Voo [voo=" + voo + ", origem=" + origem + ", destino=" + destino + ", data_saida=" + dataSaida
				+ ", saida=" + saida + ", chegada=" + chegada + ", valor=" + valor + "]";
	}

}
