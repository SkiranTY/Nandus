package com.tyss.productsales.service;

import java.util.List;

import com.tyss.productsales.dto.Products;

public interface ProductService {

	public boolean postProduct(Products products);
	
	public List<Products> getproducts();
	
	public List<Products> checkProducts();
}
