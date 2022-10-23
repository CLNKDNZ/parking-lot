package com.parking_automation.parking.service.impl;

import com.parking_automation.parking.domain.Garage;
import com.parking_automation.parking.domain.Slot;
import com.parking_automation.parking.domain.Vehicle;
import com.parking_automation.parking.exception.GarageIsFullException;
import com.parking_automation.parking.exception.NotFoundVehicleException;
import com.parking_automation.parking.exception.VehicleIsExistException;
import com.parking_automation.parking.model.dto.LeaveResponseDTO;
import com.parking_automation.parking.model.dto.ParkingResponseDTO;
import com.parking_automation.parking.model.dto.StatusResponseDTO;
import com.parking_automation.parking.model.request.ParkingRequest;
import com.parking_automation.parking.service.GarageService;
import com.parking_automation.parking.service.VehicleFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class GarageServiceImpl implements GarageService {

    private final Garage garage;

    @Override
    public ParkingResponseDTO park(ParkingRequest parkingRequest) {
        Vehicle vehicle = VehicleFactory.createVehicle(parkingRequest);
        int vehicleSize = vehicle.getVehicleSize();
        List<String> slots = findSlotListForVehicle(garage.getSlotMap(), vehicleSize);
        checkVehicleIsExist(vehicle.getLicence());
        checkGarageStatus(slots);
        vehicle.parkVehicle(slots, vehicle, garage.getSlotMap());
        return new ParkingResponseDTO(vehicle);
    }

    @Override
    public LeaveResponseDTO leave(String vehicleLicence) {
        Vehicle tobeLeaveVehicle = findVehicleByLicence(vehicleLicence);
        tobeLeaveVehicle.leaveVehicle(garage.getSlotMap());
        return new LeaveResponseDTO(tobeLeaveVehicle);
    }

    @Override
    public StatusResponseDTO status() {
        return new StatusResponseDTO(garage.getSlotMap());
    }

    private List<String> findSlotListForVehicle(Map<String, Slot> parkingSlotMap, int vehicleSize) {
        List<String> availableSlots = new ArrayList<>();
        for (Map.Entry<String, Slot> entry : parkingSlotMap.entrySet()) {
            var slot = entry.getValue();
            var slotName = new StringBuilder().append(slot.getNameConst())
                    .append(slot.getSlotNumber()).toString();

            if (slot.isAvailable()) {
                availableSlots.add(slotName);
                if (availableSlots.size() == vehicleSize) {
                    break;
                }

            } else {
                availableSlots.clear();
            }

        }
        if (availableSlots.size() != vehicleSize) {
            availableSlots.clear();
        }

        return availableSlots;
    }

    private Vehicle findVehicleByLicence(String vehicleLicence) {
        Optional<Slot> filteredSlots = garage.getSlotMap().values().stream()
                .filter(vehicle -> filterVehicle(vehicleLicence, vehicle))
                .findAny();
        return filteredSlots.get().getVehicle();
    }

    private static boolean filterVehicle(String vehicleLicence, Slot vehicle) {
        if (!isNull(vehicle.getVehicle())) {
            return vehicle.getVehicle().getLicence().equalsIgnoreCase(vehicleLicence);
        } else {
            throw new NotFoundVehicleException(vehicleLicence);
        }
    }

    private static void checkGarageStatus(List<String> slots) {
        if (slots.size() == 0)
            throw new GarageIsFullException();
    }

    private void checkVehicleIsExist(String vehicleLicence) {
        var isExist = garage.getSlotMap().values().stream().anyMatch(x -> {
            if (!isNull(x.getVehicle()))
                return x.getVehicle().getLicence().equalsIgnoreCase(vehicleLicence);
            else
                return false;
        });

        if (isExist)
            throw new VehicleIsExistException(vehicleLicence);
    }
}
