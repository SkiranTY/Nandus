package com.tyss.productsales.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.productsales.dto.Products;

@Repository
public class ProductDaoImpl implements ProductDao{

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public boolean postProduct(Products products) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(products);
		transaction.commit();
		return true;
	}

	@Override
	public List<Products> getproducts() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String info = "From Products";
		Query query = manager.createQuery(info);
		List<Products> list = query.getResultList();
		if (list == null) {
			return null;
		}
		return list;
	}

	@Override
	public List<Products> checkProducts() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String check="select * from products where product_id not in (select products from sales)";
		Query query = manager.createNativeQuery(check);
		List<Products> notsales= query.getResultList();
		if(notsales != null) {
			return null;
		}
		return notsales;
	}


}
