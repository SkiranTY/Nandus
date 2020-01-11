package com.tyss.productsales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.productsales.dao.ProductDao;
import com.tyss.productsales.dto.Products;
import com.tyss.productsales.dto.Sales;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductDao productdao;
	
	@Override
	public boolean postProduct(Products products) {		
		return productdao.postProduct(products);
	}

	@Override
	public List<Products> getproducts() {
		return productdao.getproducts();
	}

	@Override
	public List<Products> checkProducts() {
		return productdao.checkProducts();
	}

}
