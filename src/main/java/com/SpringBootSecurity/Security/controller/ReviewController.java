package com.SpringBootSecurity.Security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootSecurity.Security.dto.ReviewInterfaceDto;
import com.SpringBootSecurity.Security.entity.Review;
import com.SpringBootSecurity.Security.service.ReviewService;

@RestController
@RequestMapping("/review/api")
public class ReviewController {

	@Autowired
	private ReviewService service;

	@PostMapping("/post/both")
	public Review postboth(@RequestBody Review review) {
		return service.postboth(review);
	}

	@GetMapping("/getmultiplevalues")
	public List<ReviewInterfaceDto> getmultiplevalues(@RequestParam(value = "customerId") int cId) {
		return service.getmultiplevalues(cId);
	}

}
