package com.parking_automation.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundVehicleException.class)
    public ResponseEntity<Object> handleNotFoundVehicleException(
            NotFoundVehicleException notFoundVehicleException
    ) {

        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(notFoundVehicleException.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionDTO);
    }

    @ExceptionHandler(GarageIsFullException.class)
    public ResponseEntity<Object> handleGarageIsFullException(
            GarageIsFullException garageIsFullException
    ) {

        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(garageIsFullException.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionDTO);
    }

    @ExceptionHandler(VehicleIsExistException.class)
    public ResponseEntity<Object> handleVehicleIsExistException(
            VehicleIsExistException vehicleIsExistException
    ) {

        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(vehicleIsExistException.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionDTO);
    }

}
