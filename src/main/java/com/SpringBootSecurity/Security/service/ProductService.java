package com.SpringBootSecurity.Security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootSecurity.Security.entity.Products;
import com.SpringBootSecurity.Security.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public Products productPost(Products products) {
		return productRepository.save(products);
	}

}
