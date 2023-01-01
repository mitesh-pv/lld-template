package com.lld.app.parkingLot.exception;

public class ParkingFullException extends RuntimeException {
    public ParkingFullException(String message) {
        super(message);
    }
}
