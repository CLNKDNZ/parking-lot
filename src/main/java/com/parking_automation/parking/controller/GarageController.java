package com.parking_automation.parking.controller;

import com.parking_automation.parking.model.dto.LeaveResponseDTO;
import com.parking_automation.parking.model.dto.ParkingResponseDTO;
import com.parking_automation.parking.model.dto.StatusResponseDTO;
import com.parking_automation.parking.model.request.LeaveRequest;
import com.parking_automation.parking.model.request.ParkingRequest;
import com.parking_automation.parking.service.GarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/garage")
@RequiredArgsConstructor
public class GarageController {

    private final GarageService garageService;

    @PostMapping("/park")
    public ResponseEntity<ParkingResponseDTO> park(@Valid @RequestBody ParkingRequest parkingRequest) {
        var responseDTO = garageService.park(parkingRequest);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/leave")
    public ResponseEntity<LeaveResponseDTO> leave(@Valid @RequestBody LeaveRequest leaveRequest) {
        var leaveResponseDTO = garageService.leave(leaveRequest.getVehicleLicence());
        return new ResponseEntity(leaveResponseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/status")
    public ResponseEntity<StatusResponseDTO> status() {
        var statusResponseDTO = garageService.status();
        return new ResponseEntity(statusResponseDTO, HttpStatus.OK);
    }


}
