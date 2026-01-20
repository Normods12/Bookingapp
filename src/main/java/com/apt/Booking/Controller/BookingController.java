package com.apt.Booking.Controller;

import com.apt.Booking.Requests.AddService;
import com.apt.Booking.Requests.AddUser;
import com.apt.Booking.Requests.BookAppointment;
import com.apt.Booking.Requests.MoveForward;
import com.apt.Booking.Response.AllServices;
import com.apt.Booking.Response.AllUsers;
import com.apt.Booking.Response.ListAppointments;
import com.apt.Booking.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @RequestMapping("/about")
    public String about() {
        return "This is Service Booking management ";
    }

    @RequestMapping("/NewUser")
    public void addUser(@RequestBody AddUser addUser) {
        bookingService.addUser(addUser);
    }

    @RequestMapping("/NewService")
    public void addService(@RequestBody AddService addService) {
        bookingService.addService(addService);
    }

    @RequestMapping("/allUsers")
    public List<AllUsers> listAllUsers() {
        return bookingService.listAllUsers();
    }

    @RequestMapping("/allServices")
    public List<AllServices> listAllServices() {
        return bookingService.listAllServices();
    }

    @RequestMapping("/book")
    public void bookAppointment(@RequestBody BookAppointment bookAppointment) {
        bookingService.bookAppointment(bookAppointment);
    }

    @RequestMapping("/status/{id}")
    public String getStatus(@PathVariable("id")  int id) {
       return bookingService.getStatus(id);
    }

    @RequestMapping("/cancel/{id}")
    public void cancel(@PathVariable("id")  int id) {
        bookingService.cancel(id);
    }

    @RequestMapping("/move/{id}")
    public void moveQueue(@PathVariable("id")  int id) {
        bookingService.moveQueue(id);
    }

    @RequestMapping("/allAppointments")
    public List<ListAppointments> listAllAppointments() {
        return bookingService.listAppointments();
    }



}
