package com.apt.Booking.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class AllServices {
    private long id;
    private String serviceName;

    @Override
    public String toString() {
        return "AllServices{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
