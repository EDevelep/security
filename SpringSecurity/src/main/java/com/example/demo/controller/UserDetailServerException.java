package com.example.demo.controller;

public class UserDetailServerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9040873251432335105L;
	
	public UserDetailServerException(String message, Exception ex) {
		super(message);
	}
	
	public UserDetailServerException(String message) {
		super(message);
	}

}
