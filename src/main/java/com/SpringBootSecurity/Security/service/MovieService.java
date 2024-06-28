package com.SpringBootSecurity.Security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringBootSecurity.Security.common.ApiResponse;
import com.SpringBootSecurity.Security.dto.MovieDto;
import com.SpringBootSecurity.Security.dto.RequsetMeta;
import com.SpringBootSecurity.Security.entity.Movies;
import com.SpringBootSecurity.Security.interceptor.JwtInterceptor;
import com.SpringBootSecurity.Security.repository.MovieRepository;

@Service
public class MovieService implements MovieImplement{
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private RequsetMeta requsetMeta;

	@Override
	public MovieDto post(MovieDto dto) {
		Movies movies=new Movies();
		movies.setMovieNo(dto.getMovieNo());
		movies.setMovieName(dto.getMovieName());
		movies.setHeroin(dto.getHeroin());
		movies.setHero(dto.getHero());
		movieRepository.save(movies);
		return dto;
		
	}

	@Override
	public List<Movies> getall() {
		
		List<Movies> optional=movieRepository.findAll();
		System.out.println(requsetMeta.getUserName());
		return optional;
	}

}
