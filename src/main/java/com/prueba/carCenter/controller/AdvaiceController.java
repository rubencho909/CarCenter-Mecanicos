package com.prueba.carCenter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.prueba.carCenter.dto.ErrorDto;
import com.prueba.carCenter.exception.RequestExceptionHandler;

@RestControllerAdvice
public class AdvaiceController {
	
	@ExceptionHandler(value = RequestExceptionHandler.class)
    public ResponseEntity<ErrorDto> requestExceptionHandler(RequestExceptionHandler exceptionHandler){
    ErrorDto errorDto = ErrorDto.builder().message(exceptionHandler.getMessage()).build();
    return new ResponseEntity<>(errorDto, exceptionHandler.getHttpStatus());
    }


}
