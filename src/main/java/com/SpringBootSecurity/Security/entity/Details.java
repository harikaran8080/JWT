package com.SpringBootSecurity.Security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="details")
public class Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int detailId;
	
	private int cid;
	
	private int productsId;
	
	private String place;
	
}
