package com.alten.ca.hotel.service;

import com.alten.ca.hotel.dao.HotelBookingDAO;
import com.alten.ca.hotel.error.BookedDaysException;
import com.alten.ca.hotel.model.entity.Guest;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService{

    private HotelBookingDAO hotelBookingDAO;
    private Validations validations;

    public HotelServiceImpl(HotelBookingDAO hotelBookingDAO, Validations validations) {
        this.hotelBookingDAO = hotelBookingDAO;
        this.validations = validations;
    }

    @Override
    public void bookRoom(Guest guest) {

        validations.bookingValidations(guest);
        hotelBookingDAO.bookRoom(guest);

    }

    @Override
    public void cancelReservation(int id) {

        hotelBookingDAO.cancelReservation(hotelBookingDAO.findReservationById(id)
                .orElseThrow(() -> new BookedDaysException("The ID: " +id+ " could not be found.")));
    }

    public Guest findReservationById(int id) {

        return hotelBookingDAO.findReservationById(id)
                .orElseThrow(() -> new BookedDaysException("The ID: " +id+ " could not be found."));

    }

    public Guest updateReservation(Guest guest) {

        validations.bookingValidations(guest);
        return hotelBookingDAO.updateReservation(findReservationById(guest.getId()));
    }
}
