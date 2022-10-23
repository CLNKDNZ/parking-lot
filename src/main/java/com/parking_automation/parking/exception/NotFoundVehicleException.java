package com.parking_automation.parking.exception;

public class NotFoundVehicleException extends RuntimeException {
    private static String VEHICLE_EXCEPTION_MESSAGE = "The vehicle with plate number %s was not found in the parking lot";

    public NotFoundVehicleException(String plateNumber) {
        super(String.format(VEHICLE_EXCEPTION_MESSAGE, plateNumber));
    }
}
