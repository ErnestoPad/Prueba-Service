package com.prueba.exceptions;

public class SolicitudNotFoundExcepetion extends Exception {
	private static final long serialVersionUID = 1L;
	
    public SolicitudNotFoundExcepetion() {
        super("Solicitud no existe");
    }

    public SolicitudNotFoundExcepetion(String message, Throwable cause) {
        super(message, cause);
    }
}
