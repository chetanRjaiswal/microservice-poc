package com.app.hotel.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hotel.entities.Hotel;
import com.app.hotel.exceptions.ResourceNotFoundException;
import com.app.hotel.repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {

		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {

		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String id) {

		return hotelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id" + id));
	}

}
