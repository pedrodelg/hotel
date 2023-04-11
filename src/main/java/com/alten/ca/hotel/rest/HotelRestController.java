package com.alten.ca.hotel.rest;

import com.alten.ca.hotel.model.entity.Guest;
import com.alten.ca.hotel.model.rest.BookingResponse;
import com.alten.ca.hotel.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HotelRestController {

    private HotelService hotelService;

    public HotelRestController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/book-room")
    public ResponseEntity<BookingResponse> bookRoom(@Valid @RequestBody Guest guest){

        hotelService.bookRoom(guest);
        BookingResponse bookingResponse = new BookingResponse("The reservation has been created successfully", guest);

        return new ResponseEntity<BookingResponse>(bookingResponse, null, HttpStatus.CREATED);
    }

    @DeleteMapping("cancel-reservation/{id}")
    public ResponseEntity<BookingResponse> cancelReservation(@PathVariable int id) {
        hotelService.cancelReservation(id);
        BookingResponse bookingResponse = new BookingResponse("The reservation for id " +id+ " has been canceled successfully", null);

        return new ResponseEntity<BookingResponse>(bookingResponse, null, HttpStatus.OK);
    }

    @GetMapping("/find-reservation/{id}")
    public Guest findReservationById(@PathVariable int id) {
        return hotelService.findReservationById(id);
    }

    @PutMapping("/update-reservation")
    public ResponseEntity<BookingResponse> updateReservation(@RequestBody Guest guest) {

        BookingResponse bookingResponse = new BookingResponse("The reservation for has been updated successfully", hotelService.updateReservation(guest));

        return new ResponseEntity<BookingResponse>(bookingResponse, null, HttpStatus.OK);

    }
}
