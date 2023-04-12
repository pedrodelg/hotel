package com.alten.ca.hotel.service;

import com.alten.ca.hotel.dao.HotelBookingDAO;
import com.alten.ca.hotel.error.BookedDaysException;
import com.alten.ca.hotel.model.entity.Guest;
import com.alten.ca.hotel.util.Utils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Validations {

    private HotelBookingDAO hotelBookingDAO;

    public Validations(HotelBookingDAO hotelBookingDAO) {
        this.hotelBookingDAO = hotelBookingDAO;
    }

    public void bookingValidations(LocalDate arrivalDate, LocalDate departureDate){

        Utils.departureNotBeforeArrival(arrivalDate, departureDate);
        Utils.thirtyDaysValidation(arrivalDate);
        Utils.notLongerThreeDays(arrivalDate, departureDate);

        List<Guest> guestList = hotelBookingDAO.findReservationArrivalDepartureDate(arrivalDate, departureDate);

        if (guestList.size() != 0){
            throw new BookedDaysException("The room is booked for selected dates");

        }
    }

}
