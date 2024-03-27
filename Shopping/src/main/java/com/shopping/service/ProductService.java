package com.shopping.service;

import java.util.List;

import com.shopping.model.Product;

public interface ProductService {
	
	Product addProduct(Product product);
	
	Product getProduct(int id);
	
	void deleteProduct(int id);
	
	Product updateProduct(int id, Product product);
	
	List<Product> getAllProducts();

}
