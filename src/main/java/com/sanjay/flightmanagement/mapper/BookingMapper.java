package com.sanjay.flightmanagement.mapper;

import com.sanjay.flightmanagement.dto.request.BookingRequestDto;
import com.sanjay.flightmanagement.dto.response.BookingResponseDto;
import com.sanjay.flightmanagement.entity.Booking;

public class BookingMapper {

    public static BookingResponseDto mapToBookingResponseDto(Booking booking) {

        BookingResponseDto responseDto = new BookingResponseDto();

        responseDto.setBooking_id(booking.getBooking_id());
        responseDto.setBooking_date(booking.getBooking_date());
        responseDto.setFlight_number(booking.getFlight().getFlight_number());
        responseDto.setUser_name(booking.getUser().getUser_name());
        responseDto.setSeatCount(booking.getSeat_count());
        responseDto.setStatus(booking.getStatus());

        return responseDto;
    }
}
