package com.SpringBootSecurity.Security.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootSecurity.Security.entity.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, UUID>{

}
