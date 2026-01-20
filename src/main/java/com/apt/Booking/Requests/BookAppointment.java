package com.apt.Booking.Requests;

import com.apt.Booking.Entity.Appointment;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import static com.apt.Booking.Entity.Appointment.Status.BOOKED;


@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class BookAppointment {

    private String appointmentTime;
    private long userId;
    private long serId;
   private Appointment.Status status= BOOKED;

}
