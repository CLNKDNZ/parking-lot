package com.parking_automation.parking.domain;

import com.parking_automation.parking.constant.VehicleType;

public class Jeep extends Vehicle {
    private static int JEEP_SLOT_SIZE = 2;

    public Jeep(String colour, String plateNumber) {
        super.vehicleSize = JEEP_SLOT_SIZE;
        super.vehicleType = VehicleType.JEEP;
        super.colour = colour;
        super.plateNumber = plateNumber;
    }
}
