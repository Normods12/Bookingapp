package com.apt.Booking.Requests;

import com.apt.Booking.Entity.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;




@Data
@Component
@NoArgsConstructor
@AllArgsConstructor

public class AddUser {

    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private User.Role role;


}
