package com.softworkshub.ratingservices.Services;

import com.softworkshub.ratingservices.entity.Rating;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RatingServices {

    ResponseEntity<Rating> addRating(Rating rating);

    ResponseEntity<List<Rating>> getAllRatings();

    ResponseEntity<Rating> getRatingById(String id);

    ResponseEntity<Rating> updateRating(Rating rating);

    ResponseEntity<Rating> deleteRating(String id);

    ResponseEntity<List<Rating>> getRatingsByHotelId(String hotelId);

    ResponseEntity<List<Rating>> getRatingByUserId(String userId);
}
