package com.alten.ca.hotel.util;

import com.alten.ca.hotel.error.BookedDaysException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class Utils {

    public static void notLongerThreeDays(LocalDate arrivalDate, LocalDate departureDate) {

        long bookedDays = ChronoUnit.DAYS.between(arrivalDate, departureDate);

        if (bookedDays > 3){
            throw new BookedDaysException("The stay can’t be longer than 3 days.");
        }
    }

    public static void thirtyDaysValidation(LocalDate arrivalDate){

        long rangeCurrentArrivalD = ChronoUnit.DAYS.between(LocalDate.now(), arrivalDate);

        if (rangeCurrentArrivalD > 30){
            throw new BookedDaysException("You can’t reserve more than 30 days in advance.");
        }

    }

    public static void departureNotBeforeArrival(LocalDate arrivalDate, LocalDate departureDate){

        if (departureDate.isBefore(arrivalDate)){
            throw new BookedDaysException("Departure Date can't be before Arrival Date.");
        }
    }
}
