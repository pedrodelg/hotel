package com.alten.ca.hotel.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "HotelBooking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "Name")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(name = "ArrivalDate")
    @Future
    @NotNull(message = "ArrivalDate is mandatory")
    private LocalDate arrivalDate;

    @Column(name = "DepartureDate")
    @Future
    @NotNull(message = "DepartureDate is mandatory")
    private LocalDate departureDate;

}
