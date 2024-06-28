package com.SpringBootSecurity.Security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootSecurity.Security.dto.MovieDto;
import com.SpringBootSecurity.Security.dto.RequsetMeta;
import com.SpringBootSecurity.Security.entity.Movies;
import com.SpringBootSecurity.Security.service.MovieImplement;


@RestController
@RequestMapping("/rest/api")
public class MovieController {
	
	@Autowired
	private MovieImplement implement;

	
	
	@PostMapping("/post")
	public MovieDto post(@RequestBody MovieDto dto){
		return implement.post(dto);
	}
	
	@GetMapping("/getall")
	public List<Movies> getall() {
		return implement.getall();
	}

}
