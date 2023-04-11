package com.alten.ca.hotel.service;

import com.alten.ca.hotel.model.entity.Guest;

public interface HotelService {

    public void bookRoom(Guest guest);

    public void cancelReservation(int Id);

    public Guest findReservationById(int id);

    public Guest updateReservation(Guest guest);

}
