package com.parking_automation.parking.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ParkingRequest {

    @NotBlank
    private String vehicleType;
    @NotBlank
    private String plateNumber;
    @NotBlank
    private String colour;

}
