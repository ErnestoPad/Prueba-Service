package com.prueba.exceptions;

public class ClienteNotFoundEception extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public ClienteNotFoundEception() {
        super("Cliente no existe");
    }

    public ClienteNotFoundEception(String message, Throwable cause) {
        super(message, cause);
    }

}
