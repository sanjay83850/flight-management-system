package com.sanjay.flightmanagement.service;

import com.sanjay.flightmanagement.dto.request.BookingRequestDto;
import com.sanjay.flightmanagement.dto.response.BookingResponseDto;
import com.sanjay.flightmanagement.entity.User;

import java.util.List;

public interface BookingService {

    //Create booking
    BookingResponseDto createBooking(BookingRequestDto requestDto);

    //Cancel booking
    String cancelBooking(Long booking_id);

    //Get booking by id
    BookingResponseDto getBookingById(Long booking_id);

}
