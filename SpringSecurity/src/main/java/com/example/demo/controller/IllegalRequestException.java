package com.example.demo.controller;

public class IllegalRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9040873251432335105L;
	
	public IllegalRequestException(String message) {
		super(message);
	}

}
