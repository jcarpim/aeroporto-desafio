package com.desafio.aeroporto.enums;

public enum Operadora {
	UBER("Uber"), NOVE_NOVE("99");
	private String label;

	private Operadora(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
