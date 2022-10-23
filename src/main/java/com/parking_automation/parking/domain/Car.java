package com.parking_automation.parking.domain;

import com.parking_automation.parking.constant.VehicleType;

public class Car extends Vehicle {
    private static int CAR_SIZE = 1;

    public Car(String colour, String plateNumber) {
        super.vehicleSize = CAR_SIZE;
        super.vehicleType = VehicleType.CAR;
        super.colour = colour;
        super.plateNumber = plateNumber;
    }
}
