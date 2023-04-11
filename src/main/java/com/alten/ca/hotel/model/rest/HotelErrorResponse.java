package com.alten.ca.hotel.model.rest;

import lombok.Data;

@Data
public class HotelErrorResponse {

    private int status;
    private String message;
    private long timeStamp;
}
