package com.capgemini.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.springrest.beans.ProductPrimaryInfo;
import com.capgemini.springrest.dao.ProductDAO;


@Service
public class ProductServiceImple implements ProductService {
@Autowired
private ProductDAO dao;

@Override
public List<ProductPrimaryInfo> getAllProducts() {
	
	return dao.getAllProducts();
}

@Override
public boolean createProductInfo(ProductPrimaryInfo info) {
	
	return dao.createProductInfo(info);
}

@Override
public boolean deleteProductInfo(String productName) {

	return dao.deleteProductInfo(productName);
}

@Override
public boolean updateProductInfo(ProductPrimaryInfo info) {
	
	return dao.updateProductInfo(info);
}
	
	
}
