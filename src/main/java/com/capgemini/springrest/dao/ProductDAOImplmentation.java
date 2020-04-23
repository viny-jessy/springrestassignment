package com.capgemini.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.capgemini.springrest.beans.ProductPrimaryInfo;
import com.capgemini.springrest.exceptions.ProductException;

@Repository
public class ProductDAOImplmentation implements ProductDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public List<ProductPrimaryInfo> getAllProducts() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select p from ProductPrimaryInfo p";
		Query query = manager.createQuery(jpql);
		List<ProductPrimaryInfo>  recordList = query.getResultList();
		manager.close();
		return recordList;
	}

	@Override
	public boolean createProductInfo(ProductPrimaryInfo info) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		boolean isAdded=false;
		try {
			transaction.begin();
			manager.persist(info);
			transaction.commit();
			isAdded=true;
			System.out.println("Added");
		} catch(Exception e) {
			e.printStackTrace();
		 throw new ProductException("product already exists");
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public boolean deleteProductInfo(String productName) {
		
		boolean isDeleted=false;
		EntityManager manager = factory.createEntityManager();
		ProductPrimaryInfo productInfoBean = manager.find(ProductPrimaryInfo.class, productName);
		
		if(productInfoBean!=null) {
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.remove(productInfoBean);
			transaction.commit();
			isDeleted=true;
		}
		manager.close();
		return isDeleted;
	}

	@Override
	public boolean updateProductInfo(ProductPrimaryInfo info) {
		boolean isUpdated=false;
		EntityManager manager = factory.createEntityManager();
		ProductPrimaryInfo productInfo = manager.find(ProductPrimaryInfo.class,info.getProductName());
		
		if(productInfo != null) {
			
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			
			productInfo.setProductName(info.getProductName());
			//productInfo.setImageUrl(info.getImageUrl());
			//productInfo.setPrice(info.getPrice());
			//productInfo.setProductdescription(info.getProductdescription());
			
			transaction.commit();
			isUpdated=true;
		}
		manager.close();
		return isUpdated;
	
	}
}
