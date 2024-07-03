package com.SpringBootSecurity.Security.service;


import java.util.List;

import com.SpringBootSecurity.Security.common.ApiResponse;
import com.SpringBootSecurity.Security.dto.LoginDto;
import com.SpringBootSecurity.Security.dto.ReviewInterfaceDto;
import com.SpringBootSecurity.Security.dto.SignUpDto;
import com.SpringBootSecurity.Security.entity.Review;

public interface ServiceImplement {

	ApiResponse signup(SignUpDto dto);

	ApiResponse login(LoginDto dto);

	ApiResponse privateapi(String authorization) throws Exception;
	
	ApiResponse validatepassword(LoginDto dto);

	



	

}
