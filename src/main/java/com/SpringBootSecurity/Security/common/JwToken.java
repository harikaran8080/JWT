package com.SpringBootSecurity.Security.common;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.SpringBootSecurity.Security.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwToken {
	
	private static String secret="athu secret vella solla koodathu";
	
	private static long expiryduration=60*60;
	
	
	public static String JwtGenarate(User user) {
		long milliTime=System.currentTimeMillis();
		long expiryTime=milliTime + expiryduration * 1000;
		Date issuedAt = new Date(milliTime);
		Date expiryAt = new Date(expiryTime);
		
		Claims claims=Jwts.claims().setIssuer(String.valueOf(user.getId()));
		claims.setIssuedAt(issuedAt).setExpiration(expiryAt);
		claims.put("type",user.getUserType());
		claims.put("name",user.getName());
		claims.put("emailId",user.getEmailId());
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
		
	}
	public void verify(String authorization)throws Exception{
		try {
			Jwts.parser().setSigningKey(secret).parsePlaintextJws(authorization);
		}
		catch(Exception e ) {
			throw new Exception();
		}
	}

}
