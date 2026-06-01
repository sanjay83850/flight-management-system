package com.sanjay.flightmanagement.controller;

import com.sanjay.flightmanagement.dto.request.FlightRequestDto;
import com.sanjay.flightmanagement.dto.response.BookingResponseDto;
import com.sanjay.flightmanagement.dto.response.FlightResponseDto;
import com.sanjay.flightmanagement.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public ResponseEntity<FlightResponseDto> addFlight(@Valid @RequestBody FlightRequestDto requestDto) {
        return new ResponseEntity<>(
                flightService.addFlight(requestDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public List<FlightResponseDto> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public FlightResponseDto getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightResponseDto> updateFlight(@PathVariable Long id, @RequestBody FlightRequestDto requestDto) {
        return new ResponseEntity<>(
                flightService.updateFlight(id, requestDto),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return "Flight deleted successfully";
    }

}
