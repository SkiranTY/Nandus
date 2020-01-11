package com.tyss.productsales.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.productsales.dto.Products;
import com.tyss.productsales.dto.Sales;

@Repository
public class SalesDaoImpl implements SalesDao{

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	
	@Override
	public boolean postSales(Sales sales,int productid) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		sales.setProducts(manager.find(Products.class, productid));
		manager.persist(sales);
		transaction.commit();
		return true;
	}

	@Override
	public List<Sales> getSales() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String info = "From Sales";
		Query query = manager.createQuery(info);
		List<Sales> list = query.getResultList();
		if (list == null) {
			return null;
		}
		return list;
	}
	
	

}
