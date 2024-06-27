package com.SpringBootSecurity.Security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "movies")
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieNo;
	
	@Column(name = "moviname")
	private String movieName;
	
	@Column(name = "hero")
	private String hero;
	
	@Column(name = "heroin")
	private String heroin;

}
