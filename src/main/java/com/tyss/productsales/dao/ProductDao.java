package com.tyss.productsales.dao;

import java.util.List;

import com.tyss.productsales.dto.Products;

public interface ProductDao {

	public boolean postProduct(Products products);
	
	public List<Products> getproducts();
	
	public List<Products> checkProducts();
	
}
