package com.SpringBootSecurity.Security.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.SpringBootSecurity.Security.common.ApiResponse;
import com.SpringBootSecurity.Security.common.JwToken;
import com.SpringBootSecurity.Security.entity.User;
import com.SpringBootSecurity.Security.repository.UserRepository;
import com.SpringBootSecurity.Security.signupdto.SignUpDto;

@Service
public class LoginService implements ServiceImplement{
	
	@Autowired
	private UserRepository repository;

	/**
	 *
	 */
	@Override
	public ApiResponse signup(SignUpDto dto) {
		ApiResponse apiResponse= new ApiResponse();
		User user=new User();
		user.setName(dto.getName());
		user.setGender(dto.getGender());
		user.setEmailId(dto.getEmailId());
		user.setPhoneNumber(dto.getPhoneNumber());
		user.setPassword(dto.getPassword());
		
		if(user.getPassword()==null || user.getPassword().isEmpty()) {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			apiResponse.setError("Bad Request");
			apiResponse.setData("No Data Found");
			
		}
		else {
			apiResponse.setStatus(HttpStatus.OK.value());
			apiResponse.setData(user);
			repository.save(user);
			String token = JwToken.JwtGenarate(user);
			Map<String, Object>data=new HashMap<String, Object>();
			data.put("Access Token",token);
			apiResponse.setData(data);
		}
		
		return apiResponse;
	}

	

}
