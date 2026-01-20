package com.apt.Booking.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
public class Appointment {
    public Appointment() {
        queueNumber++;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String appointmentTime;
    public enum Status{
        BOOKED,
        IN_QUEUE,
        COMPLETED,
        CANCELLED
    }
    @Enumerated(EnumType.STRING)
    private Status status;
    private int queueNumber=0;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "serviceId")
    private Services service;


}
