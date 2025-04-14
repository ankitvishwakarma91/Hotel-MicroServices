package com.softworkshub.userservice.feign;


import com.softworkshub.userservice.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("RATING-SERVICES")
public interface RatingClient {

    @GetMapping("rating/getRatingByUserId/{id}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("id") String userId);


}
