package com.sanjay.flightmanagement.dto.request;

import com.sanjay.flightmanagement.enums.BookingStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class BookingRequestDto {

    private Long user_id;

    private Long flight_id;

    private Integer seat_count;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Long flight_id) {
        this.flight_id = flight_id;
    }

    public Integer getSeat_count() {
        return seat_count;
    }

    public void setSeat_count(Integer seat_count) {
        this.seat_count = seat_count;
    }
}
