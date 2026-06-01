package com.sanjay.flightmanagement.mapper;

import com.sanjay.flightmanagement.dto.request.FlightRequestDto;
import com.sanjay.flightmanagement.dto.response.FlightResponseDto;
import com.sanjay.flightmanagement.entity.Flight;

public class FlightMapper {

    public static Flight mapToFlight(FlightRequestDto requestDto) {
        Flight flight = new Flight();

        flight.setFlight_number(requestDto.getFlight_number());
        flight.setFlight_source(requestDto.getFlight_source());
        flight.setFlight_destination(requestDto.getFlight_destination());
        flight.setFlight_departure_time(requestDto.getFlight_departure_time());
        flight.setFlight_arrival_time(requestDto.getFlight_arrival_time());
        flight.setFlight_total_seats(requestDto.getFlight_total_seats());
        flight.setFlight_available_seats(requestDto.getFlight_available_seats());
        flight.setPrice(requestDto.getPrice());

        return flight;
    }

    public static FlightResponseDto mapToFlightResponseDto(Flight flight) {
        FlightResponseDto response = new FlightResponseDto();

        response.setFlight_id(flight.getFlight_id());
        response.setFlight_number(flight.getFlight_number());
        response.setFlight_source(flight.getFlight_source());
        response.setFlight_destination(flight.getFlight_destination());
        response.setFlight_departure_time(flight.getFlight_departure_time());
        response.setFlight_arrival_time(flight.getFlight_arrival_time());
        response.setFlight_available_seats(flight.getFlight_available_seats());
        response.setPrice(flight.getPrice());

        return response;
    }

    public static void updateFlightFromDto(FlightRequestDto requestDto, Flight flight) {

        if(requestDto.getFlight_number() != null) {
            flight.setFlight_number(requestDto.getFlight_number());
        }
        if(requestDto.getFlight_source() != null) {
            flight.setFlight_source(requestDto.getFlight_source());
        }
        if(requestDto.getFlight_departure_time() != null) {
            flight.setFlight_departure_time(requestDto.getFlight_departure_time());
        }
        if(requestDto.getFlight_arrival_time() != null) {
            flight.setFlight_arrival_time(requestDto.getFlight_arrival_time());
        }
        if(requestDto.getFlight_destination() != null) {
            flight.setFlight_destination(requestDto.getFlight_destination());
        }
        if(requestDto.getFlight_total_seats() != null) {
            flight.setFlight_total_seats(requestDto.getFlight_total_seats());
        }
        if(requestDto.getFlight_available_seats() != null) {
            flight.setFlight_available_seats(requestDto.getFlight_available_seats());
        }
        if(requestDto.getPrice() != null) {
            flight.setPrice(requestDto.getPrice());
        }

    }
}

