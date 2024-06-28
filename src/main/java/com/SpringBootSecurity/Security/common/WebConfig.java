package com.SpringBootSecurity.Security.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.SpringBootSecurity.Security.dto.RequsetMeta;
import com.SpringBootSecurity.Security.interceptor.JwtInterceptor;
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	
	@Autowired
	private JwtInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
		        
	}
	
	@Bean
	@RequestScope
	public RequsetMeta getRequestMeta() {
		return new RequsetMeta();
	}
	
	@Bean
	public JwtInterceptor interceptor2() {
		return new JwtInterceptor(getRequestMeta());
	}


}
