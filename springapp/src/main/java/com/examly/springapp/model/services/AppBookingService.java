package com.examly.springapp.model.services;

import com.examly.springapp.model.entitymodels.Booking;
import com.examly.springapp.model.repository.AppBookingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppBookingService {
    private final AppBookingRepo appBookingRepo;
    AppBookingService(AppBookingRepo appBookingRepo){
        this.appBookingRepo = appBookingRepo;
    }

    public Booking addBooking(Booking booking) {
        return appBookingRepo.save(booking);
    }

    public List<Booking> getAllUserBooking(Long id) {
        return appBookingRepo.getBookingByUserid(id);
    }

    public List<Booking> getAllAdminBooking(Long id) {
        return appBookingRepo.getBookingByAdminid(id);
    }
}
