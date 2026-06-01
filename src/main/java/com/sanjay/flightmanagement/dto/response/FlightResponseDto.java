package com.sanjay.flightmanagement.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FlightResponseDto {

    private Long flight_id;

    private String flight_number;

    private String flight_source;

    private String flight_destination;

    private LocalDateTime flight_departure_time;

    private LocalDateTime flight_arrival_time;

    private Integer flight_available_seats;

    private BigDecimal price;

    public Long getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Long flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getFlight_source() {
        return flight_source;
    }

    public void setFlight_source(String flight_source) {
        this.flight_source = flight_source;
    }

    public String getFlight_destination() {
        return flight_destination;
    }

    public void setFlight_destination(String flight_destination) {
        this.flight_destination = flight_destination;
    }

    public LocalDateTime getFlight_departure_time() {
        return flight_departure_time;
    }

    public void setFlight_departure_time(LocalDateTime flight_departure_time) {
        this.flight_departure_time = flight_departure_time;
    }

    public LocalDateTime getFlight_arrival_time() {
        return flight_arrival_time;
    }

    public void setFlight_arrival_time(LocalDateTime flight_arrival_time) {
        this.flight_arrival_time = flight_arrival_time;
    }

    public Integer getFlight_available_seats() {
        return flight_available_seats;
    }

    public void setFlight_available_seats(Integer flight_available_seats) {
        this.flight_available_seats = flight_available_seats;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
