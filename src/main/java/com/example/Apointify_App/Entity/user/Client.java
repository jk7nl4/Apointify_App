package com.example.Apointify_App.Entity.user;

import com.example.Apointify_App.Entity.Appointment;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Client")
public class Client {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "city")
    private String city;

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "client")
    private List<Appointment> appointments = new ArrayList<>();


    // Add more client-specific fields here

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
    }
}
