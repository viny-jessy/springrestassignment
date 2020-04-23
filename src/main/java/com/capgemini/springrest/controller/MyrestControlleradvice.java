package com.capgemini.springrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.springrest.beans.ProductResponse;
import com.capgemini.springrest.exceptions.ProductException;

@RestControllerAdvice

public class MyrestControlleradvice {
	@ExceptionHandler
	public ProductResponse myExceptionHnadler(ProductException productException) {
		ProductResponse response = new ProductResponse();
		response.setError(true);
		response.setMessage(productException.getMessage());
		
		return response;
	}

}
