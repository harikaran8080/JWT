package com.SpringBootSecurity.Security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootSecurity.Security.entity.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer>{

}
