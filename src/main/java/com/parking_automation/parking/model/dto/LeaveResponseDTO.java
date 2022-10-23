package com.parking_automation.parking.model.dto;

import com.parking_automation.parking.domain.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.util.stream.Collectors;

@Getter
@Setter
public class LeaveResponseDTO {

    private Vehicle leavedVehicleDetail;
    private String message;

    public LeaveResponseDTO() {
    }

    public LeaveResponseDTO(Vehicle leavedVehicleDetail) {
        this.leavedVehicleDetail = leavedVehicleDetail;
        var formattedMessage = String.format("The %s %s with the number plate %s left from [%s] slots",
                leavedVehicleDetail.getColour(),
                leavedVehicleDetail.getVehicleType().name(),
                leavedVehicleDetail.getPlateNumber(),
                leavedVehicleDetail.getSlots().stream().map(Object::toString)
                        .collect(Collectors.joining(", "))
        );
        this.message = formattedMessage;
    }
}
