package com.parking_automation.parking.model.dto;

import com.parking_automation.parking.domain.Slot;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class StatusResponseDTO {

    private Map<String, Slot> slot;

    public StatusResponseDTO(Map<String, Slot> slot) {
        this.slot = slot;
    }
}
