package com.softworkshub.ratingservices.Exceptions;

public class ResourcesNotFoundExceptions extends RuntimeException {

    public ResourcesNotFoundExceptions() {
        super("Resources not found");
    }

    public ResourcesNotFoundExceptions(String message) {
        super(message);
    }
}
