package com.SpringBootSecurity.Security.service;


import java.util.List;
import java.util.UUID;

import com.SpringBootSecurity.Security.common.ApiResponse;
import com.SpringBootSecurity.Security.common.ReviewInterface;
import com.SpringBootSecurity.Security.dto.LoginDto;
import com.SpringBootSecurity.Security.dto.SignUpDto;
import com.SpringBootSecurity.Security.entity.Review;

public interface ServiceImplement {

	ApiResponse signup(SignUpDto dto);

	ApiResponse login(LoginDto dto);

	ApiResponse privateapi(String authorization) throws Exception;
	
	ApiResponse validatepassword(LoginDto dto);

	List<ReviewInterface> getmultiplevalues(UUID cId);

	Review postmultiple(Review review);

}
