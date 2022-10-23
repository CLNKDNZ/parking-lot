package com.parking_automation.parking.service;

import com.parking_automation.parking.model.dto.LeaveResponseDTO;
import com.parking_automation.parking.model.dto.ParkingResponseDTO;
import com.parking_automation.parking.model.dto.StatusResponseDTO;
import com.parking_automation.parking.model.request.LeaveRequest;
import com.parking_automation.parking.model.request.ParkingRequest;


public interface GarageService {
    ParkingResponseDTO park(ParkingRequest parkingRequest);

    LeaveResponseDTO leave(String vehicleLicence);

    StatusResponseDTO status();
}
