package com.SpringBootSecurity.Security.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.SpringBootSecurity.Security.common.JwToken;
import com.SpringBootSecurity.Security.dto.RequsetMeta;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

	@Autowired
	private JwToken jwToken;

	private RequsetMeta requsetMeta;

	public JwtInterceptor(RequsetMeta requsetMeta) {
		this.requsetMeta = requsetMeta;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("JWT interceptor - pre Handle Method is Calling");

		String auth = request.getHeader("authorization");

		if (!(request.getRequestURI().contains("login") || request.getRequestURI().contains("signup"))) {
			Claims claims = jwToken.verify(auth);

			requsetMeta.setUserName(claims.get("name").toString());
			requsetMeta.setEmailId(claims.get("emailId").toString());
			requsetMeta.setUserType(claims.get("type").toString());
//			requsetMeta.setUserId(Long.valueOf(claims.getIssuer()));
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
