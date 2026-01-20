package com.apt.Booking.Repository;

import com.apt.Booking.Entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<Services,Integer> {
}
