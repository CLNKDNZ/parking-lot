package com.parking_automation.parking.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Slot {

    private boolean isAvailable = true;
    private Vehicle vehicle;
    private String nameConst;
    private int slotNumber;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.nameConst = "P";
    }
}
