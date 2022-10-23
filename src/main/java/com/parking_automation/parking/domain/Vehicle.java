package com.parking_automation.parking.domain;

import com.parking_automation.parking.constant.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@Getter
public abstract class Vehicle {
    @Setter
    protected List<String> slots;

    @Setter
    protected String licence;

    protected int vehicleSize;

    protected VehicleType vehicleType;

    @Setter
    protected String colour;

    public void parkVehicle(List<String> slots, Vehicle vehicle, Map<String, Slot> garage) {
        vehicle.setSlots(slots);
        for (String slotKey : slots) {
            Slot slot = garage.get(slotKey);
            slot.setAvailable(false);
            slot.setVehicle(vehicle);
        }
    }

    public void leaveVehicle(Map<String, Slot> garage) {
        for (Map.Entry<String, Slot> entry : garage.entrySet()) {
            var vehicle = entry.getValue().getVehicle();
            if (!isNull(vehicle) && vehicle.getLicence().equals(this.getLicence())) {
                entry.getValue().setVehicle(null);
                entry.getValue().setAvailable(true);
            }
        }
    }
}
