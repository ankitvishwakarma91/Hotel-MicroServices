package com.softworkshub.hotelservices.services;

import com.softworkshub.hotelservices.entity.Hotel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelServices {

    ResponseEntity<Hotel> createHotel(Hotel hotel);

    ResponseEntity<List<Hotel>> getAllHotels();

    ResponseEntity<Hotel> getHotelById(String id);
}
