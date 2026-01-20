package com.apt.Booking.Response;

import com.apt.Booking.Entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ListAppointments {
    @Override
    public String toString() {
        return "ListAppointments{" +
                "id=" + id +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", status=" + status +
                '}';
    }

    private long id;
    private String appointmentTime;
    private Appointment.Status status;

}
