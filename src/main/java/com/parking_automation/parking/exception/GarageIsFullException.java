package com.parking_automation.parking.exception;

public class GarageIsFullException extends RuntimeException {
    private static String GARAGE_IS_FULL_EXCEPTION_MESSAGE = "Garage is full";

    public GarageIsFullException() {
        super(GARAGE_IS_FULL_EXCEPTION_MESSAGE);
    }
}
