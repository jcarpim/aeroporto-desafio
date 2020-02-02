package com.desafio.aeroporto.exception;

public class AeroportoException extends Exception{

private static final long serialVersionUID = 1L;
	
	public AeroportoException(String message,Throwable tr) {
		super(message,tr);
	}
}
