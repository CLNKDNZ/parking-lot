package com.parking_automation.parking.domain;

import com.parking_automation.parking.constant.VehicleType;

public class Truck extends Vehicle {
    private static int TRUCK_SLOT_SIZE = 4;

    public Truck(String colour, String plateNumber) {
        super.vehicleSize = TRUCK_SLOT_SIZE;
        super.vehicleType = VehicleType.TRUCK;
        super.colour = colour;
        super.plateNumber = plateNumber;
    }
}
