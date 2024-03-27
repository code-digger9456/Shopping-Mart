package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Product;
import com.shopping.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody Product product)
	{
		try {
		Product saveProduct = productService.addProduct(product);
		
		return new ResponseEntity<String>("Product added successfully!!", HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<String>("Product dose not added!!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneProduct(@PathVariable int id)
	{
		try {
		   Product product = productService.getProduct(id);
		   
		   return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Product not found!!!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOneProduct(@PathVariable int id)
	{
		try {
			productService.deleteProduct(id);
			return new ResponseEntity<String>("Product Deleted Successfully!!!!", HttpStatus.OK);
		}
		catch (Exception e) {
		 
			return new ResponseEntity<String>("Product Not Found!!!",HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateOneProduct(@PathVariable int id ,@RequestBody Product product)
	{
		if(productService.updateProduct(id, product).getId()>0)
		{
			return new ResponseEntity<String>("Product Updated Successfully!!!", HttpStatus.ACCEPTED);
		}
		else {
			
			return new ResponseEntity<String>("Product not fount!!!", HttpStatus.BAD_GATEWAY);
		}
	}
	
	
	
	

}
