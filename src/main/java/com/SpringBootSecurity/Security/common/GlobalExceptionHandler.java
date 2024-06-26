package com.SpringBootSecurity.Security.common;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ApiResponse> handleException(Exception e) {
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setError("oops...something went wrong");
		apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.body(apiResponse);
		
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ApiResponse> handleAccessDeniedException(AccessDeniedException e){
		
		ApiResponse response=new ApiResponse();
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setError(e.getMessage());
		
		return ResponseEntity
				.status(response.getStatus())
				.body(response);
	}
	
	
	
	

}


