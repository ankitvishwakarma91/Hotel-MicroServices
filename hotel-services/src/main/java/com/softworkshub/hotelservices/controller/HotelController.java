package com.softworkshub.hotelservices.controller;


import com.softworkshub.hotelservices.entity.Hotel;
import com.softworkshub.hotelservices.services.impl.HotelServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelServicesImpl hotelServices;

    @PostMapping("/create-hotel")
    public ResponseEntity<Hotel> crateHotel(@RequestBody Hotel hotel) {
        return hotelServices.createHotel(hotel);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return hotelServices.getAllHotels();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {
        return hotelServices.getHotelById(id);
    }

}
