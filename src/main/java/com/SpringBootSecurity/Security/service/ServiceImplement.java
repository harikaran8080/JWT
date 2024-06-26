package com.SpringBootSecurity.Security.service;


import com.SpringBootSecurity.Security.common.ApiResponse;
import com.SpringBootSecurity.Security.dto.LoginDto;
import com.SpringBootSecurity.Security.dto.SignUpDto;

public interface ServiceImplement {

	ApiResponse signup(SignUpDto dto);

	ApiResponse login(LoginDto dto);

	ApiResponse privateapi(String authorization) throws Exception;

}
