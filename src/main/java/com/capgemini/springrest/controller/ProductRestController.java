package com.capgemini.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.springrest.beans.ProductPrimaryInfo;
import com.capgemini.springrest.beans.ProductResponse;
import com.capgemini.springrest.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping(path="/getAllProducts", produces = { MediaType.APPLICATION_XML_VALUE})
	//@ResponseBody{
	public ProductResponse getAllProducts() {
		List<ProductPrimaryInfo> recordList =service.getAllProducts();
			
		ProductResponse response = new ProductResponse();
		if(recordList !=  null && !recordList.isEmpty()) {
			response.setProductsinfo(recordList);
		}else {
		response.setError(true);
		response.setMessage("Employee Id Not Found");
	
	}
		return response;
	}
	@PostMapping(path="/addProduct",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	//@ResponseBody
	public ProductResponse addProduct(@RequestBody ProductPrimaryInfo produtinfo) {
		
		boolean isadded = service.createProductInfo(produtinfo);
		ProductResponse response = new ProductResponse();
		if(isadded) {
			response.setMessage("Record Insertred Successfully");
		}
		else {
			response.setError(true);
			response.setMessage("Unable to add product!");
		}
		return response;
	}
	
	@DeleteMapping(path="/deleteProductInfo/{productName}",
					consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
					produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
			
			public ProductResponse deleteProductInfo(@PathVariable(name = "productName") String productName) {
		boolean isDeleted = service.deleteProductInfo(productName);		
		
		ProductResponse response = new ProductResponse();
			
				if(isDeleted) {
					response.setMessage("Record for product name" + productName  +" deleted sucessfully");
				}
				else {
					response.setError(true);
					response.setMessage("product name" + productName + "not found");
				}
				return response;
			}

			@PutMapping(path="/updateProductInfo",
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
			
			public ProductResponse updateEmployeeInfo(@RequestBody ProductPrimaryInfo info) {
				
				boolean isupdated = service.updateProductInfo(info);
				ProductResponse response = new ProductResponse();
				if(isupdated) {
					response.setMessage("Record updated Successfully");
				}
				else {
					response.setError(true);
					response.setMessage("Unable to update product!");
				}
				return response;
			}

}//End of class
