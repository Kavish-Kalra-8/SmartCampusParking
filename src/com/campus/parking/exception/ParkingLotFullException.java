package com.campus.parking.exception;

public class ParkingLotFullException extends Exception {
    public ParkingLotFullException(String message) {
        super(message);
    }
}