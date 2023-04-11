package com.alten.ca.hotel.error;

import com.alten.ca.hotel.model.rest.HotelErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class HotelRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<HotelErrorResponse> handleException(BookedDaysException exc){

        HotelErrorResponse error = new HotelErrorResponse();

        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<HotelErrorResponse> handleExceptionConstrainViolation (SQLIntegrityConstraintViolationException exc){

        HotelErrorResponse error = new HotelErrorResponse();

        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        error.setMessage("There's a reservation for this ID");
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<HotelErrorResponse> handleValidException(Exception exc) {

        HotelErrorResponse error = new HotelErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Invalid date or missing a field");
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
//    @ExceptionHandler
//    public ResponseEntity<HotelErrorResponse> handleException(Exception exc){
//
//        HotelErrorResponse error = new HotelErrorResponse();
//
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }

}
