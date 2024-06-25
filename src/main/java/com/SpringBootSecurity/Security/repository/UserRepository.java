package com.SpringBootSecurity.Security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SpringBootSecurity.Security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	@Query(value="select * from user where email_id=:emailId and password=:password",nativeQuery=true)
	User findByEmailidPassword(String emailId, String password);

}
