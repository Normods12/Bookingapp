package com.apt.Booking.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class AllUsers {


    private long id;
    private String name;

    @Override
    public String toString() {
        return "AllUsers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
