package com.SpringBootSecurity.Security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootSecurity.Security.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

}
