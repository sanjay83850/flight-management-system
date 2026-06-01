package com.sanjay.flightmanagement.service;

import com.sanjay.flightmanagement.dto.request.FlightRequestDto;
import com.sanjay.flightmanagement.dto.response.FlightResponseDto;

import java.util.List;

public interface FlightService {

    FlightResponseDto addFlight(FlightRequestDto requestDto);

    List<FlightResponseDto> getAllFlights();

    FlightResponseDto getFlightById(Long id);

    FlightResponseDto updateFlight(Long id, FlightRequestDto requestDto);

    void deleteFlight(Long id);
}
