package com.example.demo.controller;

public class AuthnatationReq {

	public AuthnatationReq(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public AuthnatationReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
