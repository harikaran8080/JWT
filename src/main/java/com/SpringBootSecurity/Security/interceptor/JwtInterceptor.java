package com.SpringBootSecurity.Security.interceptor;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.SpringBootSecurity.Security.common.JwToken;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtInterceptor implements HandlerInterceptor{
	
	@Autowired
	private JwToken jwToken;
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("JWT interceptor - pre Handle Method is Calling");
		
		
		String auth=request.getHeader("authorization");
		
		jwToken.verify(auth);
		
		if (! (request.getRequestURI().contains("login")|| request.getRequestURI().contains("signup"))) {
			jwToken.verify(auth);
			
		}
		return true;
		}
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView modelAndView) throws Exception{
		System.out.println("Post Handle Method Is Calling");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,Exception exception) {
		System.out.println("Request and Response is Completed");
	

	}
}
