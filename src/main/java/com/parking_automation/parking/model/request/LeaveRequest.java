package com.parking_automation.parking.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LeaveRequest {
    @NotBlank(message = "Vehicle plate number cannot be null...")
    private String plateNumber;
}
