package com.apt.Booking.Repository;

import com.apt.Booking.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment,Integer> {

}
