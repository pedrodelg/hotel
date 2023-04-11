package com.alten.ca.hotel.error;

public class BookedDaysException extends RuntimeException{

    public BookedDaysException(String message) {
        super(message);
    }

    public BookedDaysException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookedDaysException(Throwable cause) {
        super(cause);
    }
}
