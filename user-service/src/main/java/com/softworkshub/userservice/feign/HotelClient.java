package com.softworkshub.userservice.feign;


import com.softworkshub.userservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("HOTEL-SERVICES")
public interface HotelClient {

    @GetMapping("hotel/get/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id);
}
