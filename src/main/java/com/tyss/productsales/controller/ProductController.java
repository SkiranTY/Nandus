package com.tyss.productsales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.productsales.dto.Products;
import com.tyss.productsales.dto.Response;
import com.tyss.productsales.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	Response response = new Response();
	
	
	@PostMapping(path="/products", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Response addproducts(@RequestBody Products products) {
		if(productservice.postProduct(products)) {
			response.setMessagecode(200);
			response.setMessageStatus("posted successfully");
		}else {
			response.setMessagecode(400);
			response.setMessageStatus("Invalid data not able to post");
		}
		return response;
	}
	
	@GetMapping(path="/products",produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getproducts() {
		List<Products> listproducts=productservice.getproducts();
		if(listproducts!=null) {
			response.setMessagecode(200);
			response.setMessageStatus("got the list of products");
			response.setProducts(listproducts);
		}else {
			response.setMessagecode(400);
			response.setMessageStatus("deatils not got,some bad request");
		}	
		return response;
	}
	
	@GetMapping(path="/getnotsales",produces = MediaType.APPLICATION_JSON_VALUE)
	public Response checknotSales() {
	List<Products> notsales = productservice.checkProducts();
	if(notsales !=null) {
		response.setMessagecode(200);
		response.setMessageStatus("product which are not sold list");
		response.setProducts(notsales);
	}else {
		response.setMessagecode(400);
		response.setMessageStatus("products are not getting");
	}
	return response;
	}
}
