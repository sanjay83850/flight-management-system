package com.sanjay.flightmanagement.controller;

import com.sanjay.flightmanagement.dto.request.BookingRequestDto;
import com.sanjay.flightmanagement.dto.response.BookingResponseDto;
import com.sanjay.flightmanagement.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    public BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingResponseDto> createBooking(@Valid @RequestBody BookingRequestDto requestDto) {
        return new ResponseEntity<>(
                bookingService.createBooking(requestDto),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{booking_id}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long booking_id) {
        return ResponseEntity.ok(
                bookingService.cancelBooking(booking_id)
        );
    }

    @GetMapping("/{booking_id}")
    public ResponseEntity<BookingResponseDto> getBookingByid(@PathVariable Long booking_id) {
        return ResponseEntity.ok(
                bookingService.getBookingById(booking_id)
        );
    }
}
