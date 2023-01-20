package com.app.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.rating.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{

	//custom finders
	List<Rating> findByUserId(String userId);
	//custom finders
	List<Rating> findByHotelId(String hotelId);

}
