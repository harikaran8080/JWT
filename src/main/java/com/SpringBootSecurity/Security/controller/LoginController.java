package com.SpringBootSecurity.Security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.SpringBootSecurity.Security.common.ApiResponse;
import com.SpringBootSecurity.Security.service.ServiceImplement;
import com.SpringBootSecurity.Security.signupdto.SignUpDto;

@Controller
public class LoginController {
	
	@Autowired
	private ServiceImplement implement;
	
	
	
	@PostMapping("/signup")
	public ResponseEntity<ApiResponse> signup(@RequestBody SignUpDto dto) {
		ApiResponse apiResponse= implement.signup(dto);
		return ResponseEntity
				.status(apiResponse.getStatus())
				.body(apiResponse);
		
	}
}