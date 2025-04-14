package com.softworkshub.hotelservices.exceptions;

public class ResourceNotFoundExceptions extends RuntimeException {

    public ResourceNotFoundExceptions() {
        super("Resource not found");
    }

    public ResourceNotFoundExceptions(String message) {
        super(message);
    }
}
