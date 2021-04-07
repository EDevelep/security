package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class UserDetailExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(UserDetailExceptionHandler.class);
	
	
	@ExceptionHandler(value = UserDetailServerException.class)
	public ResponseEntity<Response<String>> handleGenericException(UserDetailServerException dse, Exception ex) {
		Response<String> response = new Response<>();
		response.setMessage(dse.getMessage());
		response.setStatus(StatusEnum.FAILURE.name());
		logger.error(dse.getMessage(), ex);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	} 

	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<Response<String>> handleIllegalRequestException(IllegalArgumentException dse) {
		Response<String> response = new Response<>();
		response.setMessage(dse.getMessage());
		response.setStatus(StatusEnum.FAILURE.name());
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	} 

}
