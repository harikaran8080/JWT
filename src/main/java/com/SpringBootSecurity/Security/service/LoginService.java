package com.SpringBootSecurity.Security.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.SpringBootSecurity.Security.common.ApiResponse;
import com.SpringBootSecurity.Security.common.JwToken;
import com.SpringBootSecurity.Security.common.PasswordUtil;
import com.SpringBootSecurity.Security.dto.LoginDto;
import com.SpringBootSecurity.Security.dto.ReviewInterfaceDto;
import com.SpringBootSecurity.Security.dto.SignUpDto;
import com.SpringBootSecurity.Security.entity.Review;
import com.SpringBootSecurity.Security.entity.User;
import com.SpringBootSecurity.Security.repository.ReviewRepository;
import com.SpringBootSecurity.Security.repository.UserRepository;

@Service
public class LoginService implements ServiceImplement {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private JwToken jwToken;

	@Override
	public ApiResponse signup(SignUpDto dto) {
		ApiResponse apiResponse = new ApiResponse();
		User user = new User();
		user.setName(dto.getName());
		user.setGender(dto.getGender());
		user.setEmailId(dto.getEmailId());
		user.setPhoneNumber(dto.getPhoneNumber());
		user.setPassword(PasswordUtil.passwordencrypte(dto.getPassword()));

		if (user.getPassword() == null || user.getPassword().isEmpty()) {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			apiResponse.setError("Bad Request");
			apiResponse.setData("No Data Found");

		} else {
			apiResponse.setStatus(HttpStatus.OK.value());
			apiResponse.setData(user);
			repository.save(user);

		}

		return apiResponse;
	}

	@Override
	public ApiResponse login(LoginDto dto) {
		ApiResponse apiResponse = new ApiResponse();
		User user = repository.findByEmailidPassword(dto.getEmailId(), dto.getPassword());
		if (user == null) {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			apiResponse.setData("Login Failed");
			apiResponse.setError("Bad Request");
			return apiResponse;
		} else {
			apiResponse.setStatus(HttpStatus.OK.value());
			String token = jwToken.JwtGenarate(user);
			Map<String, Object> data = new HashMap<>();
			data.put("Access Token", token);
			apiResponse.setData(data);
			return apiResponse;
		}

	}

	@Override
	public ApiResponse privateapi(String authorization) throws Exception {
		ApiResponse apiResponse = new ApiResponse();
//		try {
		jwToken.verify(authorization);
		apiResponse.setStatus(HttpStatus.OK.value());
		apiResponse.setData("this is private api");
//		}
//		catch (Exception e)
//		{
//			throw new AccessDeniedException("Access Denied");
//		}
//		

		return apiResponse;
	}

	@Override
	public ApiResponse validatepassword(LoginDto dto) {
		ApiResponse apiResponse = new ApiResponse();
		Optional<User> optional = repository.findByEmail(dto.getEmailId());
		User user = optional.get();
		String realPassword = user.getPassword();
		String loginPassword = PasswordUtil.passwordencrypte(dto.getPassword());
		if (realPassword.equals(loginPassword)) {
			apiResponse.setStatus(HttpStatus.OK.value());
			apiResponse.setData(user);
		}else {
			
		}

		return apiResponse;
	}


	

	
	



	

	

}