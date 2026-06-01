package com.sanjay.flightmanagement.repository;

import com.sanjay.flightmanagement.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
