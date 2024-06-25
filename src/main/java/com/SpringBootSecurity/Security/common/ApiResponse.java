package com.SpringBootSecurity.Security.common;

import lombok.Data;

@Data
public class ApiResponse {
	
	private Integer status;
	private Object data;
	private Object error;
	
	

}
