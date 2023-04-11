package com.alten.ca.hotel.dao;

import com.alten.ca.hotel.model.entity.Guest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HotelBookingDAO {

    public void bookRoom(Guest guest);

    public List<Guest> findReservationArrivalDepartureDate(LocalDate arrivalDate, LocalDate departureDate);

    public void cancelReservation(Guest guest);

    public Optional<Guest> findReservationById(int id);

    public Guest updateReservation (Guest guest);
}
