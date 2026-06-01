package com.sanjay.flightmanagement.repository;

import com.sanjay.flightmanagement.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
