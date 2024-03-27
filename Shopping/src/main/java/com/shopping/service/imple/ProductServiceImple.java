package com.shopping.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.model.Product;
import com.shopping.repo.ProductRepo;
import com.shopping.service.ProductService;

@Service
public class ProductServiceImple implements ProductService{
	
	@Autowired
	ProductRepo productRepo;

	@Override
	public Product addProduct(Product product) {
		Product p = new Product();
		p.setName(product.getName());
		p.setDecription(product.getDecription());
		p.setPrice(product.getPrice());
		p.setImages(product.getImages());
		p.setCategory(product.getCategory());
		
		
		productRepo.save(p);
		
		return null;
	}

	@Override
	public Product getProduct(int id) {
		
		Product product = productRepo.findById(id).get();
		
		return product;
	}

	@Override
	public void deleteProduct(int id) {
		
		Product product = productRepo.findById(id).get();	
		productRepo.delete(product);
		
	}

	@Override
	public Product updateProduct(int id, Product product) {
	
		Product existProduct = new Product();
		existProduct.setName(product.getName());
		existProduct.setDecription(product.getDecription());
		existProduct.setCategory(product.getCategory());
		existProduct.setPrice(product.getPrice());
		existProduct.setImages(product.getImages());
		
		 return productRepo.save(existProduct);
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		return null;
	}

}
