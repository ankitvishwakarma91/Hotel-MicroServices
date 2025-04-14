package com.softworkshub.ratingservices.Services.Impl;

import com.softworkshub.ratingservices.Exceptions.ResourcesNotFoundExceptions;
import com.softworkshub.ratingservices.Services.RatingServices;
import com.softworkshub.ratingservices.entity.Hotel;
import com.softworkshub.ratingservices.entity.Rating;
import com.softworkshub.ratingservices.repo.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class RatingServicesImpl implements RatingServices {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public ResponseEntity<Rating> addRating(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        Rating save = ratingRepository.save(rating);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> all = ratingRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Rating> getRatingById(String id) {
        Rating rating = ratingRepository.findById(id).orElseThrow( () -> new ResourcesNotFoundExceptions("Ratings  not found"));
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Rating> updateRating(Rating rating) {
        Rating update = ratingRepository.save(rating);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Rating> deleteRating(String id) {
        Rating rating = ratingRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundExceptions("Ratings  not found"));
        ratingRepository.deleteById(id);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Rating>> getRatingsByHotelId(String hotelId) {
        return new ResponseEntity<>(ratingRepository.findByHotelId(hotelId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Rating>> getRatingByUserId(String userId) {
        return new ResponseEntity<>(ratingRepository.findByUserId(userId), HttpStatus.OK);
    }


}
