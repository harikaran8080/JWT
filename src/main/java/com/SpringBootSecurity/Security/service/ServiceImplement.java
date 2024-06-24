package com.SpringBootSecurity.Security.service;

import com.SpringBootSecurity.Security.common.ApiResponse;
import com.SpringBootSecurity.Security.signupdto.SignUpDto;

public interface ServiceImplement {

	

	ApiResponse signup(SignUpDto dto);

	

}
