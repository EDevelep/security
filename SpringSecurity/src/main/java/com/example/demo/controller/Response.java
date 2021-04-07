package com.example.demo.controller;

public class Response<T> {
	private String status;
	private String message;
	private T data;
	
	
	public Response() {
		status = StatusEnum.SUCCESS.name();
	}
	
	public Response(T data, StatusEnum staus, String message) {
		this.data = data;
		this.status = staus.name();
		this.message = message;
	}
	public Response(String status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
