package com.prueba.carCenter.dto;

import lombok.Builder;

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
