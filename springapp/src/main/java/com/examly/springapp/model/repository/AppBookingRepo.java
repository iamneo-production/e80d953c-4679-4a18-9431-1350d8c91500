package com.examly.springapp.model.repository;

import com.examly.springapp.model.entitymodels.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppBookingRepo extends JpaRepository<Booking,Long> {
    List<Booking> getBookingByAdminid(Long id);
    List<Booking> getBookingByUserid(Long id);
}
