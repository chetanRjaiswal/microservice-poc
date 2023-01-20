package com.app.hotel.services;

import java.util.List;

import com.app.hotel.entities.Hotel;

public interface HotelService {

	//create
		Hotel createHotel(Hotel hotel);
	
	//get all
		List<Hotel> getAllHotels();
	
	//get single
		Hotel getHotel(String id);
	
}
