package com.desafio.aeroporto.model;

import java.io.Serializable;

public class Aeroporto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String aeroporto;
	private String cidade;
	
	public Aeroporto(String nome, String aeroporto, String cidade) {
		super();
		this.nome = nome;
		this.aeroporto = aeroporto;
		this.cidade = cidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAeroporto() {
		return aeroporto;
	}
	public void setAeroporto(String aeroporto) {
		this.aeroporto = aeroporto;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
