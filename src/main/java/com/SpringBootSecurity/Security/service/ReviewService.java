package com.SpringBootSecurity.Security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootSecurity.Security.dto.ReviewInterfaceDto;
import com.SpringBootSecurity.Security.entity.Review;
import com.SpringBootSecurity.Security.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository repository;

	public Review postboth(Review review) {
		return repository.save(review);
	}
	
	public List<ReviewInterfaceDto> getmultiplevalues(int cId) {
		return repository.findByMultipleValues(cId);
	}
	
	

}
