package com.app.rating.service;

import java.util.List;

import com.app.rating.entities.Rating;

public interface RatingService {

	Rating createRating(Rating rating);
	
	List<Rating> getAllRating();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
	
}
