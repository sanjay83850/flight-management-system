package com.sanjay.flightmanagement.service.Implementation;

import com.sanjay.flightmanagement.dto.request.FlightRequestDto;
import com.sanjay.flightmanagement.dto.response.FlightResponseDto;
import com.sanjay.flightmanagement.entity.Flight;
import com.sanjay.flightmanagement.exception.FlightNotFoundException;
import com.sanjay.flightmanagement.mapper.FlightMapper;
import com.sanjay.flightmanagement.repository.FlightRepository;
import com.sanjay.flightmanagement.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public FlightResponseDto addFlight(FlightRequestDto requestDto) {

        //DTO to Entity
        Flight flight = FlightMapper.mapToFlight(requestDto);

        Flight savedFlight = flightRepository.save(flight);

        //Entity to DTO
        return FlightMapper.mapToFlightResponseDto(savedFlight);
    }

    @Override
    public List<FlightResponseDto> getAllFlights() {

        List<Flight> flights = flightRepository.findAll();

        return flights.stream()
                .map(FlightMapper::mapToFlightResponseDto)
                .toList();
    }

    @Override
    public FlightResponseDto getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() ->
                        new FlightNotFoundException("Flight Not Found"));

        return FlightMapper.mapToFlightResponseDto(flight);
    }

    @Override
    public FlightResponseDto updateFlight(Long id, FlightRequestDto requestDto) {
        Flight existingFlight = flightRepository.findById(id)
                .orElseThrow(() ->
                        new FlightNotFoundException("Flight Not Found"));

        FlightMapper.updateFlightFromDto(requestDto, existingFlight);

        Flight updatedFlight = flightRepository.save(existingFlight);

        return FlightMapper.mapToFlightResponseDto(updatedFlight);
    }

    @Override
    public void deleteFlight(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() ->
                        new FlightNotFoundException("Flight Not Found"));

        flightRepository.delete(flight);
    }

}
