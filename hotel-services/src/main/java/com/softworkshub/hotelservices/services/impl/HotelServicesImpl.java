package com.softworkshub.hotelservices.services.impl;


import com.softworkshub.hotelservices.entity.Hotel;
import com.softworkshub.hotelservices.exceptions.ResourceNotFoundExceptions;
import com.softworkshub.hotelservices.repo.HotelRepository;
import com.softworkshub.hotelservices.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServicesImpl implements HotelServices {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public ResponseEntity<Hotel> createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        Hotel save = hotelRepository.save(hotel);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> all = hotelRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Hotel> getHotelById(String id) {
        Hotel byId = hotelRepository.findById(id).orElseThrow( () -> new ResourceNotFoundExceptions("resource not found"));
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }
}
