package com.apt.Booking.Service;
import com.apt.Booking.Entity.Appointment;
import com.apt.Booking.Entity.Services;
import com.apt.Booking.Entity.User;
import com.apt.Booking.Repository.AppointmentRepo;
import com.apt.Booking.Repository.ServiceRepo;
import com.apt.Booking.Repository.UserRepo;
import com.apt.Booking.Requests.AddService;
import com.apt.Booking.Requests.AddUser;
import com.apt.Booking.Requests.BookAppointment;
import com.apt.Booking.Requests.MoveForward;
import com.apt.Booking.Response.AllServices;
import com.apt.Booking.Response.AllUsers;
import com.apt.Booking.Response.ListAppointments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookingService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    AppointmentRepo appointmentRepo;
    @Autowired
    ServiceRepo serviceRepo;


    public void addUser(AddUser addUser) {
        User user = new User();
        user.setName(addUser.getName());
        user.setEmail(addUser.getEmail());
        user.setRole(addUser.getRole());
        userRepo.save(user);
    }

    public void addService(AddService addService) {
        Services service = new Services();
        service.setServiceName(addService.getServiceName());
        service.setAvgTimePerUser(addService.getAvgTimePerUser());
        serviceRepo.save(service);
    }


    public List<AllUsers> listAllUsers() {
        List<AllUsers> allUsers = new ArrayList<>();
        List<User> users = userRepo.findAll();
        for(User user : users) {
            AllUsers allUser = new AllUsers();
            allUser.setName(user.getName());
            allUser.setId(user.getId());
            allUsers.add(allUser);
        }
        return allUsers;
    }

    public List<AllServices> listAllServices() {
        List<AllServices> allServices = new ArrayList<>();
        List<Services> services = serviceRepo.findAll();
        for(Services service : services) {
            AllServices allService = new AllServices();
            allService.setServiceName(service.getServiceName());
            allService.setId(service.getId());
            allServices.add(allService);
        }
        return allServices;
    }

    public void bookAppointment(BookAppointment bookAppointment) {
        Appointment appointment = new Appointment();
        Services services = serviceRepo.findById((int) bookAppointment.getSerId())
                .orElseThrow(()-> new RuntimeException("Invalid service id"));
        User user = userRepo.findById((int)bookAppointment.getUserId())
                .orElseThrow(()-> new RuntimeException("No Users Found"));
        appointment.setUser(user);
        appointment.setService(services);
        appointment.setAppointmentTime(bookAppointment.getAppointmentTime());
        appointment.setStatus(bookAppointment.getStatus());
        appointmentRepo.save(appointment);
    }

public String getStatus(int id) {
        Appointment appointment = appointmentRepo.findById(id).orElseThrow(()-> new RuntimeException("Invalid appointment id"));
        String status = appointment.getStatus().toString();
    return "status: " + status;
}

public void moveQueue(int id){
        User user =  userRepo.findById(id).orElseThrow(()-> new RuntimeException("Invalid user id"));
        if(user.getRole().equals("staff")){
            List<Appointment>  appointments = appointmentRepo.findAll();
            List<Appointment> appointments1 = appointmentRepo.findAll();
            int i=0;
            for(Appointment appointment : appointments){
                if(appointment.getQueueNumber()==0){
                    appointment.setStatus(Appointment.Status.COMPLETED);

                }
                else if(appointment.getStatus().equals("BOOKED")){
                    appointment.setQueueNumber(i+1);
                }
                appointments1.add(appointment);
            }
            appointmentRepo.saveAll(appointments1);
        }
        else{
            System.out.println("Not Permitted");
        }


}

public void cancel(int id) {
        Appointment appointment = appointmentRepo.findById(id).orElseThrow(()-> new RuntimeException("Invalid appointment id"));
        appointment.setStatus(Appointment.Status.CANCELLED);
        appointmentRepo.save(appointment);
}

public List<ListAppointments> listAppointments(){

        List<ListAppointments> listAppointments = new ArrayList<>();
        List<Appointment> appointments = appointmentRepo.findAll();
        for(Appointment appointment : appointments){
            ListAppointments listAppointment = new ListAppointments();
            listAppointment.setAppointmentTime(appointment.getAppointmentTime());
            listAppointment.setId(appointment.getId());
            listAppointment.setStatus(appointment.getStatus());
            listAppointments.add(listAppointment);
        }
        return listAppointments;
}

}
