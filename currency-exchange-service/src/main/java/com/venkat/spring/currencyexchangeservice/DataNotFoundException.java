package com.venkat.spring.currencyexchangeservice;

public class DataNotFoundException extends RuntimeException {

	private String message;

	public DataNotFoundException() {

	}

	public DataNotFoundException(String message) {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
