package com.prueba.carCenter.dto;

import lombok.Builder;


/**
 * Clase creada para manejar los errores a traves de mensajes y exception.
 * @author RUBEN DARIO PEREZ CORREDOR
 * @since 09/10/2022
 *
 */
@Builder
public class ErrorDto {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
