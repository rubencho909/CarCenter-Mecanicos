package com.prueba.carCenter.exception;

import org.springframework.http.HttpStatus;

public class RequestExceptionHandler extends RuntimeException{
	
	private HttpStatus httpStatus;

	public RequestExceptionHandler(HttpStatus httpStatus, String mensaje) {
		super(mensaje);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	

}
