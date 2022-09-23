package com.test.aeroplane.details.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<String> handleUserNotFoundException(CustomException ex, WebRequest request) {

		String response = ex.getLocalizedMessage();
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
