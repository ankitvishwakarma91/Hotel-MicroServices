package com.softworkshub.userservice.services;


import com.softworkshub.userservice.entity.Hotel;
import com.softworkshub.userservice.entity.Rating;
import com.softworkshub.userservice.entity.User;
import com.softworkshub.userservice.exceptions.ResourceNotFoundException;
import com.softworkshub.userservice.feign.HotelClient;
import com.softworkshub.userservice.feign.RatingClient;
import com.softworkshub.userservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.UUID;


@Service
public class UserServicesImpl implements UserServices{

    private final UserRepository userRepository;

    @Autowired
    private RatingClient ratingClient;

    @Autowired
    private HotelClient hotelClient;

    @Autowired
    public UserServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public ResponseEntity<User> createUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setId(randomUserId);
        User save = userRepository.save(user);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> all = userRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getUserById(String id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));


        ResponseEntity<List<Rating>> responseEntity = ratingClient.getRatingByUserId(id);
        List<Rating> ratings = responseEntity.getBody();


        ratings.forEach(rating -> {
            ResponseEntity<Hotel> hotelResponse = hotelClient.getHotelById(rating.getHotelId());
            Hotel hotel = hotelResponse.getBody();
            rating.setHotel(hotel);
        });
        user.setRatings(ratings);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<User> updateUser(User user) {
        User save = userRepository.save(user);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }


}
