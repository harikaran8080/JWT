package com.SpringBootSecurity.Security.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SpringBootSecurity.Security.common.ReviewInterface;
import com.SpringBootSecurity.Security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select * from user where email_id=:emailId and password=:password", nativeQuery = true)
	User findByEmailidPassword(String emailId, String password);

	@Query(value = "select * from user where email_id=:emailId", nativeQuery = true)
	Optional<User> findByEmail(String emailId);

	@Query(value = "select r.review_id as reviewId,c.c_name as customerName,m.moviname as movieName,r.star as star,r.description as description"
			+ "from review r inner join customer c on r.c_id = c.c_id "
			+ "inner join movies m on m.movie_no=r.movie_no where c.c_id=:cId  ", nativeQuery = true)
	List<ReviewInterface> findByMultipleValues(UUID cId);

}
