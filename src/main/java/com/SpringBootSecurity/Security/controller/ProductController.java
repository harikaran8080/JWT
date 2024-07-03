package com.SpringBootSecurity.Security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootSecurity.Security.entity.Products;
import com.SpringBootSecurity.Security.service.ProductService;

@RestController
@RequestMapping("/product/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/post")
	public Products productPost(@RequestBody Products products) {
		return productService.productPost(products);
	}
	
	
	

}
