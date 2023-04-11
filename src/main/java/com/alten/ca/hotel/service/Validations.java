package com.alten.ca.hotel.service;

import com.alten.ca.hotel.dao.HotelBookingDAO;
import com.alten.ca.hotel.error.BookedDaysException;
import com.alten.ca.hotel.model.entity.Guest;
import com.alten.ca.hotel.util.Utils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Validations {

    private HotelBookingDAO hotelBookingDAO;

    public Validations(HotelBookingDAO hotelBookingDAO) {
        this.hotelBookingDAO = hotelBookingDAO;
    }

    public void bookingValidations(Guest guest){

        Utils.reservationNextDay(guest.getArrivalDate());
        Utils.departureNotBeforeArrival(guest.getArrivalDate(), guest.getDepartureDate());
        Utils.thirtyDaysValidation(guest.getArrivalDate());
        Utils.notLongerThreeDays(guest.getArrivalDate(), guest.getDepartureDate());

        List<Guest> guestList = hotelBookingDAO.findReservationArrivalDepartureDate(guest.getArrivalDate(), guest.getDepartureDate());

        if (guestList.size() != 0){
            throw new BookedDaysException("The room is booked for selected dates");

        }
    }

}
