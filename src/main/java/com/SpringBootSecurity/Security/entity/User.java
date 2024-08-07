package com.SpringBootSecurity.Security.entity;

import java.util.UUID;

import com.SpringBootSecurity.Security.common.Constant;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator = "UUID")
	private UUID id;
	
	private String name;
	
	private String gender;
	
	private String emailId;
	
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	private String password;

}
