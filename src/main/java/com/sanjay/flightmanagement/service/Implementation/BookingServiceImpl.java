package com.sanjay.flightmanagement.service.Implementation;

import com.sanjay.flightmanagement.dto.request.BookingRequestDto;
import com.sanjay.flightmanagement.dto.response.BookingResponseDto;
import com.sanjay.flightmanagement.entity.Booking;
import com.sanjay.flightmanagement.entity.Flight;
import com.sanjay.flightmanagement.entity.User;
import com.sanjay.flightmanagement.enums.BookingStatus;
import com.sanjay.flightmanagement.exception.FlightNotFoundException;
import com.sanjay.flightmanagement.exception.SeatNotFoundException;
import com.sanjay.flightmanagement.exception.UserNotFoundException;
import com.sanjay.flightmanagement.mapper.BookingMapper;
import com.sanjay.flightmanagement.repository.BookingRepository;
import com.sanjay.flightmanagement.repository.FlightRepository;
import com.sanjay.flightmanagement.repository.UserRepository;
import com.sanjay.flightmanagement.service.BookingService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final FlightRepository flightRepo;
    private final UserRepository userRepo;

    public BookingServiceImpl(BookingRepository bookingRepo, FlightRepository flightRepo, UserRepository userRepo) {
        this.bookingRepo = bookingRepo;
        this.flightRepo = flightRepo;
        this.userRepo = userRepo;
    }

    @Transactional
    @Override
    public BookingResponseDto createBooking(BookingRequestDto requestDto) {

        //find user
        User user = userRepo.findById(requestDto.getUser_id())
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        //find flight
        Flight flight = flightRepo.findById(requestDto.getFlight_id())
                .orElseThrow(() ->
                        new FlightNotFoundException("Flight not found"));

        //Check seat availability
        if(flight.getFlight_available_seats() < requestDto.getSeat_count()) {
            throw new SeatNotFoundException("Not enough seat available");
        }

        //Reduce available seats
        flight.setFlight_available_seats(
                flight.getFlight_available_seats() - requestDto.getSeat_count()
        );

        //Create booking object
        Booking booking = new Booking();

        booking.setUser(user);
        booking.setFlight(flight);
        booking.setSeat_count(requestDto.getSeat_count());
        booking.setBooking_date(LocalDateTime.now());
        booking.setStatus(BookingStatus.CONFIRMED);

        //Save booking
        Booking savedBooking = bookingRepo.save(booking);

        return BookingMapper.mapToBookingResponseDto(savedBooking);

    }

    @Transactional
    @Override
    public String cancelBooking(Long booking_id) {

        Booking booking = bookingRepo.findById(booking_id)
                .orElseThrow(() ->
                        new RuntimeException("Booking not found")
                );

        //Change booking status
        booking.setStatus(BookingStatus.CANCELLED);

        //Restore seats
        Flight flight = booking.getFlight();

        flight.setFlight_available_seats(
                flight.getFlight_available_seats() + booking.getSeat_count()
        );

        bookingRepo.save(booking);

        return "Booking cancelled sccessfully";

    }

    @Override
    public BookingResponseDto getBookingById(Long booking_id) {

        Booking booking = bookingRepo.findById(booking_id)
                .orElseThrow(() ->
                        new RuntimeException("Booking not found")
                );

        return BookingMapper.mapToBookingResponseDto(booking);
    }

}