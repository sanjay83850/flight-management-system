package com.sanjay.flightmanagement.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FlightRequestDto {

    @NotBlank(message = "Flight number is required")
    private String flight_number;

    @NotBlank(message = "Flight Source is required")
    private String flight_source;

    @NotBlank(message = "Flight Destination is required")
    private String flight_destination;

    private LocalDateTime flight_departure_time;

    private LocalDateTime flight_arrival_time;

    @NotNull(message = "total seats required")
    @Min(value = 20, message = "Seats must be greater than 20")
    private Integer flight_total_seats;

    private Integer flight_available_seats;

    @Column(nullable = false)
    @Positive
    private BigDecimal price;

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

    public Integer getFlight_total_seats() {
        return flight_total_seats;
    }

    public void setFlight_total_seats(Integer flight_total_seats) {
        this.flight_total_seats = flight_total_seats;
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
