package com.SpringBootSecurity.Security.dto;

import lombok.Data;

@Data
public class RequsetMeta {
	
	private Long userId;
	
	private String userName;
	
	private String emailId;
	
	private String userType;

}
