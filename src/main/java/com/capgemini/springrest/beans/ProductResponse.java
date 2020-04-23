package com.capgemini.springrest.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
	
	private boolean error;
	private String message;
	
	private ProductPrimaryInfo productinfo;
	private List<ProductPrimaryInfo> productsinfo;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ProductPrimaryInfo getProductinfo() {
		return productinfo;
	}
	public void setProductinfo(ProductPrimaryInfo productinfo) {
		this.productinfo = productinfo;
	}
	public List<ProductPrimaryInfo> getProductsinfo() {
		return productsinfo;
	}
	public void setProductsinfo(List<ProductPrimaryInfo> productsinfo) {
		this.productsinfo = productsinfo;
	}
	
	
	
}
