package com.app.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
