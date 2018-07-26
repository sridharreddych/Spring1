package com.hcl.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	/*@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> handleException(Exception exception) {
		ErrorDetail errorDetail = new ErrorDetail(HttpStatus.INTERNAL_SERVER_ERROR.name(),
				HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
	}*/
	
}