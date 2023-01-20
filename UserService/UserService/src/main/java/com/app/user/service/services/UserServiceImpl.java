package com.app.user.service.services;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.user.service.entities.Hotel;
import com.app.user.service.entities.Rating;
import com.app.user.service.entities.User;
import com.app.user.service.exceptions.ResourceNotFoundException;
import com.app.user.service.external.service.HotelService;
import com.app.user.service.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomId = UUID.randomUUID().toString();
		user.setUserId(randomId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User does not exist with given Id" + userId));

		// http://localhost:8083/ratings/users/40599cf2-7b66-42c4-95a5-74c50b5c40a4
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(),
				Rating[].class);
		
		List<Rating> ratings = Arrays.asList(ratingsOfUser);

		List<Rating> ratingList = ratings.stream().map(rating -> {
			
		   //API call to hotelService to get hotel
		   //http://localhost:8082/hotels/9107a756-28dd-49bb-a4f1-63e6c2b9e7ce
			
		  //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
	      //Hotel hotel = forEntity.getBody();
	      //logger.info("response status code: {} ", forEntity.getStatusCode());
			
			System.out.println("inside ratings");
			
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			
			// set the hotel to rating
			rating.setHotel(hotel);
			// return the rating
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingList);
		return user;
	}

}
