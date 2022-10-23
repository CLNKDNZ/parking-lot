package com.parking_automation.parking.exception;

public class VehicleIsExistException extends RuntimeException {
    private static String VEHICLE_IS_EXIST_EXCEPTION_MESSAGE = "There is another vehicle with plate number is %s in the parking lot.";

    public VehicleIsExistException(String vehicleLicence) {
        super(String.format(VEHICLE_IS_EXIST_EXCEPTION_MESSAGE, vehicleLicence));
    }
}
