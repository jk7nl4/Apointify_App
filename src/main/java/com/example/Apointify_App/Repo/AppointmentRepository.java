package com.example.Apointify_App.Repo;

import com.example.Apointify_App.Entity.Appointment;
import com.example.Apointify_App.Entity.user.Avocat;
import com.example.Apointify_App.Entity.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByAvocatAndStatus(Avocat avocat, String status);
    List<Appointment> findByClient(Client client);
}
