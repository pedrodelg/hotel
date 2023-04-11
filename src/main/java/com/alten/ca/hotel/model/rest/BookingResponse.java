package com.alten.ca.hotel.model.rest;

import com.alten.ca.hotel.model.entity.Guest;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingResponse {

    private String message;
    private Guest guest;
}
