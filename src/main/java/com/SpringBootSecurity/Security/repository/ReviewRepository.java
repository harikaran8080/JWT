package com.SpringBootSecurity.Security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SpringBootSecurity.Security.dto.ReviewInterfaceDto;
import com.SpringBootSecurity.Security.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	@Query(value = "select r.review_id as reviewId,c.name as customerName,m.moviname as movieName,r.star as star,r.description as description "
			+ "from review r "
			+"inner join customer c on r.c_id = c.cid "
			+ "inner join movies m on m.movie_no=r.movie_no where r.c_id =:cId  ", nativeQuery = true)
	List<ReviewInterfaceDto> findByMultipleValues(int cId);

}
