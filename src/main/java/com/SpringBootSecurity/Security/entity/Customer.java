package com.SpringBootSecurity.Security.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID Cid;
	
	private String name;
	
	private String gender;
	
	private String emailId;
	
	private String phoneNumber;
	
	private String password;
	

}
