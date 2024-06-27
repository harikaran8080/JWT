package com.SpringBootSecurity.Security.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.SpringBootSecurity.Security.common.ApiResponse;
import com.SpringBootSecurity.Security.dto.MovieDto;
import com.SpringBootSecurity.Security.entity.Movies;

public interface MovieImplement {

	MovieDto post(MovieDto dto);

	List<Movies> getall();

}
