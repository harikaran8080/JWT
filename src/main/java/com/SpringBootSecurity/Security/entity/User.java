package com.SpringBootSecurity.Security.entity;



import com.SpringBootSecurity.Security.common.Constant;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String gender;
	private String emailId;
	private String phoneNumber;
	private String userType=Constant.USER_TYPE.NORMAL;
	private String password;
	private Integer logincount;
	private String ssoType;
	 
	

}
