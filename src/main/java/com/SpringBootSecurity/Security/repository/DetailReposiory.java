package com.SpringBootSecurity.Security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootSecurity.Security.entity.Details;

@Repository
public interface DetailReposiory extends JpaRepository<Details, Integer>{

}
