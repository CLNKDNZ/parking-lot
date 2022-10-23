package com.parking_automation.parking.model.dto;

import com.parking_automation.parking.domain.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.util.stream.Collectors;

@Getter
@Setter
public class ParkingResponseDTO {
    private Vehicle vehicle;
    private String message;

    public ParkingResponseDTO(Vehicle vehicle) {
        this.vehicle = vehicle;
        String formattedString = String.format("The %s %s with the number plate %s is parked in slots %s",
                                                vehicle.getColour(),
                                                vehicle.getVehicleType().name(),
                                                vehicle.getPlateNumber(),
                                                vehicle.getSlots().stream().map(Object::toString)
                                                                            .collect(Collectors.joining(", ")));
        this.message = formattedString;
    }
}
