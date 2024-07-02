package com.SpringBootSecurity.Security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootSecurity.Security.entity.Customer;
import com.SpringBootSecurity.Security.entity.User;
import com.SpringBootSecurity.Security.entity.UserRole;
import com.SpringBootSecurity.Security.repository.CustomerRepository;
import com.SpringBootSecurity.Security.repository.UserRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private UserRepository repository2;
	

	public Customer postBoth(Customer customer) {
		repository.save(customer);
		User user=new User();
		user.setName(customer.getName());
		user.setPassword(customer.getPassword());
		user.setPhoneNumber(customer.getPhoneNumber());
		user.setUserRole(UserRole.CUSTOMER);
		user.setGender(customer.getGender());
		user.setEmailId(customer.getEmailId());
		repository2.save(user);
		return customer;
	}


	public List<Customer> getboth() {
	    return repository.findAll();
	}

}
