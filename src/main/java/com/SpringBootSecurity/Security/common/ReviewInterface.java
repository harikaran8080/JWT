package com.SpringBootSecurity.Security.common;

import java.util.UUID;

public interface ReviewInterface {
	
	int getReviewId();
	
	UUID getCustomerName();
	
	int getMovieName();	
	
	double getStar();
	
	String getDescription();
	

}
