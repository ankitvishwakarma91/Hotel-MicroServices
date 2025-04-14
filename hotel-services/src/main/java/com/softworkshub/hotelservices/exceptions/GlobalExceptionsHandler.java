package com.softworkshub.hotelservices.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundExceptions.class)
    public ResponseEntity<Map<String, Object>> notfoundHandler(ResourceNotFoundExceptions e){
        Map<String, Object> map = new HashMap<>();
        map.put("message", e.getMessage() );
        map.put("stats", HttpStatus.NOT_FOUND);
        map.put("success",false);
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

}
