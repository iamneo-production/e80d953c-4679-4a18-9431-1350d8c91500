package com.examly.springapp.model.controllers;

import com.examly.springapp.model.entitymodels.Booking;
import com.examly.springapp.model.services.AppBookingService;
import com.examly.springapp.model.services.AppCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppBookingController {
    private final AppBookingService appBookingService;
    @Autowired
    AppBookingController(AppBookingService appBookingService){
        this.appBookingService = appBookingService;
    }

    @PostMapping("user/book")
    ResponseEntity<Booking> addBooking(@RequestBody Booking booking){
        Booking newBooking = appBookingService.addBooking(booking);
        return new ResponseEntity<Booking>(newBooking, HttpStatus.ACCEPTED);
    }
    @GetMapping("user/bookings/{id}")
    ResponseEntity<List<Booking>> getAllUserBooking(@PathVariable Long id){
        List<Booking> listOfUserBookings = appBookingService.getAllUserBooking(id);
        return new ResponseEntity<>(listOfUserBookings,HttpStatus.FOUND);
    }
    @GetMapping("admin/bookings/{id}")
    ResponseEntity<List<Booking>> getAllAdminBooking(@PathVariable Long id){
        List<Booking> listOfAdminBookings = appBookingService.getAllAdminBooking(id);
        return new ResponseEntity<>(listOfAdminBookings,HttpStatus.FOUND);
    }
}
