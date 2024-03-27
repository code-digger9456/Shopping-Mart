package com.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
