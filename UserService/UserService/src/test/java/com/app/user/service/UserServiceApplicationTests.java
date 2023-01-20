package com.app.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.user.service.entities.Rating;
import com.app.user.service.external.service.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private RatingService ratingService;	
	
	@Test
	void createRating() {
		Rating rating = new Rating();
		rating.setRating(9);
		rating.setUserId("");
		rating.setHotelId("");
		rating.setFeedback("created using feign client 2nd time");
		@SuppressWarnings("unused")
		Rating savedRating = ratingService.createRating(rating);
		System.out.println("new rating created using feign client ");
	}
}
