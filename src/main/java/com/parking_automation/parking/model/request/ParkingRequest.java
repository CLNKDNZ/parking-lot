package com.parking_automation.parking.model.request;

import com.parking_automation.parking.constant.VehicleType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ParkingRequest {

    @NotBlank
    private String vehicleType;
    @NotBlank
    private String licence;
    @NotBlank
    private String colour;

}
