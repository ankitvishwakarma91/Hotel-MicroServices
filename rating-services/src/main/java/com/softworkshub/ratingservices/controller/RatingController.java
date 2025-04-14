package com.softworkshub.ratingservices.controller;


import com.softworkshub.ratingservices.Services.Impl.RatingServicesImpl;
import com.softworkshub.ratingservices.entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {


    @Autowired
    private RatingServicesImpl ratingServices;


    @PostMapping("/create-rating")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
        return ratingServices.addRating(rating);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getAllRatings() {
        return ratingServices.getAllRatings();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String id) {
        return ratingServices.getRatingById(id);
    }

    @PostMapping("/update")
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating) {
        return ratingServices.updateRating(rating);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rating> deleteRatingById(@PathVariable String id) {
        return ratingServices.deleteRating(id);
    }

    @GetMapping("/getRatingByHotelId/{id}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("id") String hotelIds){
        return ratingServices.getRatingsByHotelId(hotelIds);
    }

    @GetMapping("/getRatingByUserId/{id}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("id") String userId){
        return ratingServices.getRatingByUserId(userId);
    }

}
