package com.SpringBootSecurity.Security.common;

import lombok.Data;

@Data
public class ApiResponse {
	
	private int status;
	private Object data;
	private Object error;
	
	

}
