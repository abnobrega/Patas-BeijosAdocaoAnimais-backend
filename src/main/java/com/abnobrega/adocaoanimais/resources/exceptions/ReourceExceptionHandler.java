package com.abnobrega.adocaoanimais.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.abnobrega.adocaoanimais.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ReourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)  	// Manipulando a excessão dessa classe
	public ResponseEntity<StandardError> objectNotFoundException(
			ObjectNotFoundException ex,
			HttpServletRequest request) {
		
		StandardError error = new StandardError(System.currentTimeMillis(),
												HttpStatus.NOT_FOUND.value(), 
												"Object Not Found", 
												ex.getMessage(), 
												request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}

}
