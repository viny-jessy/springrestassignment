package com.capgemini.springrest.service;

import java.util.List;
import com.capgemini.springrest.beans.ProductPrimaryInfo;



public interface ProductService {
	
	List<ProductPrimaryInfo> getAllProducts();
	boolean createProductInfo(ProductPrimaryInfo info);
	boolean deleteProductInfo(String productName);
	boolean updateProductInfo(ProductPrimaryInfo info);

	

}
