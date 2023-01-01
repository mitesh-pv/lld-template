package com.lld.app.parkinglot.exception;

public class InvalidParkingSpotNumberException extends RuntimeException {
    public InvalidParkingSpotNumberException(String message) {
        super(message);
    }
}
