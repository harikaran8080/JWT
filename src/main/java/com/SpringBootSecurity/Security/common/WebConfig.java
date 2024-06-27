package com.SpringBootSecurity.Security.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.SpringBootSecurity.Security.interceptor.JwtInterceptor;
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	
	@Autowired
	private JwtInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor)
		        
	}


}
