package com.alten.ca.hotel.rest;

import com.alten.ca.hotel.dao.HotelBookingDAO;
import com.alten.ca.hotel.model.entity.Guest;
import com.alten.ca.hotel.service.HotelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HotelRestController.class)
public class HotelRestControllerTest {

    @MockBean
    private HotelService hotelService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void bookRoomTest() throws Exception {

        Guest guest = new Guest(1,"Jean", LocalDate.of(2023,05,29), LocalDate.of(2023,05,30));

        mockMvc.perform(post("/api/book-room").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(guest)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void updateReservationTest() throws Exception{

        int id = 1;

        Guest guest = new Guest(id,"Jean", LocalDate.of(2023,05,29), LocalDate.of(2023,05,30));
        Guest updateGuest = new Guest(id,"Pierre", LocalDate.of(2023,04,23), LocalDate.of(2023,04,25));

        when(hotelService.updateReservation(guest)).thenReturn(guest);
        when(hotelService.updateReservation(updateGuest)).thenReturn(updateGuest);

        mockMvc.perform(put("/api/update-reservation").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateGuest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").value(updateGuest.getId())).
                 andExpect(jsonPath("$[*].name").value(updateGuest.getName()))
                .andExpect(jsonPath("$[*].arrivalDate").value(String.valueOf(updateGuest.getArrivalDate())))
                .andExpect(jsonPath("$[*].departureDate").value(String.valueOf(updateGuest.getDepartureDate()))).andDo(print());
    }
}
