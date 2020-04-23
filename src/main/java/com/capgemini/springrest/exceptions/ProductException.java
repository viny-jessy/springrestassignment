package com.capgemini.springrest.exceptions;

@SuppressWarnings("serial")
public class ProductException extends RuntimeException{
	public ProductException(String message) {
		super(message);
	}

}
