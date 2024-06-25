package com.SpringBootSecurity.Security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.SpringBootSecurity.Security.common.ApiResponse;
import com.SpringBootSecurity.Security.dto.LoginDto;
import com.SpringBootSecurity.Security.dto.SignUpDto;
import com.SpringBootSecurity.Security.service.ServiceImplement;

@Controller
public class LoginController {

	@Autowired
	private ServiceImplement implement;

	@PostMapping("/signup")
	public ResponseEntity<ApiResponse> signup(@RequestBody SignUpDto dto) {
		ApiResponse apiResponse = implement.signup(dto);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse> login(@RequestBody LoginDto dto) {
		ApiResponse apiResponse = implement.login(dto);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@GetMapping("/private/api")
	public ResponseEntity<ApiResponse> privateapi(@RequestHeader(value = "authorization") String authorization) throws Exception{
		ApiResponse apiResponse = implement.privateapi(authorization);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
	

	}
}