package com.parking_automation.parking.service;

import com.parking_automation.parking.constant.VehicleType;
import com.parking_automation.parking.domain.Car;
import com.parking_automation.parking.domain.Jeep;
import com.parking_automation.parking.domain.Truck;
import com.parking_automation.parking.domain.Vehicle;
import com.parking_automation.parking.model.request.ParkingRequest;

public class VehicleFactory {
    public static Vehicle createVehicle(ParkingRequest parkingRequest) {

        Vehicle vehicle;
        var vehicleType = parkingRequest.getVehicleType();
        var plateNumber = parkingRequest.getPlateNumber();
        var vehicleColour = parkingRequest.getColour();

        if (vehicleType.equals(VehicleType.CAR.name())) {
            vehicle = new Car(vehicleColour, plateNumber);

        } else if (vehicleType.equals(VehicleType.JEEP.name())) {
            vehicle = new Jeep(vehicleColour, plateNumber);

        } else if (vehicleType.equals(VehicleType.TRUCK.name())) {
            vehicle = new Truck(vehicleColour, plateNumber);

        } else {
            throw new RuntimeException();
        }

        return vehicle;
    }
}
