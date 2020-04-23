package com.capgemini.springrest.dao;

import java.util.List;
import com.capgemini.springrest.beans.ProductPrimaryInfo;


public interface ProductDAO {
	List<ProductPrimaryInfo> getAllProducts();
	boolean createProductInfo(ProductPrimaryInfo info);
	boolean deleteProductInfo(String productName);
	boolean updateProductInfo(ProductPrimaryInfo info);


}
