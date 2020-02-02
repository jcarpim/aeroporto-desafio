package com.desafio.aeroporto.exception;

public class VooException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VooException(String message,Throwable tr) {
		super(message,tr);
	}

}
