package com.prueba.carCenter.exception;

public class MecanicoException extends Exception {

	public MecanicoException(String mensaje) {
		super(mensaje);
	}

	public String getMessage(String string) {
		return "Error manejado" + string;
	}

}
