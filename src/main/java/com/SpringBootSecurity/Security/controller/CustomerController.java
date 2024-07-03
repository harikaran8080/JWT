package com.SpringBootSecurity.Security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootSecurity.Security.entity.Customer;
import com.SpringBootSecurity.Security.entity.Details;
import com.SpringBootSecurity.Security.service.CustomerService;

@RestController
@RequestMapping("/customer/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/post/both")
	public Customer postBoth(@RequestBody Customer customer) {
		return customerService.postBoth(customer);
	}
	
	
	@GetMapping("/get/both/all")
	public List<Customer> getboth() {
		return customerService.getboth();
				
	}
	
	@PostMapping("/details/post")
	public Details detailspost(@RequestBody Details details) {
		return customerService.detailpost(details);
	}
	

}
