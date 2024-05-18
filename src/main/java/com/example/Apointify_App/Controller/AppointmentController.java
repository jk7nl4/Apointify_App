package com.example.Apointify_App.Controller;


import com.example.Apointify_App.Dto.AppointmentDto;
import com.example.Apointify_App.Dto.AvocatDTO;
import com.example.Apointify_App.Entity.Appointment;
import com.example.Apointify_App.Entity.user.Avocat;
import com.example.Apointify_App.Repo.AvocatRepository;
import com.example.Apointify_App.Service.AppointmentService;
import com.example.Apointify_App.Service.AvocatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private AvocatService avocatService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AvocatRepository avocatRepository;

    @GetMapping("/appointment")
    public String showAppointmentForm(Model model) {
        List<AvocatDTO> avocats = avocatService.getAllAvocats();
        model.addAttribute("avocats", avocats);
        return "appointment"; // Thymeleaf template name
    }

    @PostMapping("/appointment")
    public String bookAppointment(@ModelAttribute AppointmentDto appointmentDto, Model model) {
        Appointment appointment = appointmentService.createAppointment(appointmentDto);
        model.addAttribute("appointment", appointment);
        return "redirect:/calendar"; // Redirect to the calendar page after booking
    }


    @GetMapping("/accepted-appointments/{avocatId}")
    @ResponseBody
    public List<AppointmentDto> getAcceptedAppointmentsForAvocat(@PathVariable Integer avocatId) {
        Avocat avocat = avocatRepository.findById(avocatId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Avocat Id:" + avocatId));
        List<AppointmentDto> appointment = appointmentService.getAllAcceptedAppointmentsForAvocat(avocat);
        return appointment;
    }
    @PostMapping("/appointments") // Use a specific path for creating appointments
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDto appointmentDTO) {
        appointmentService.createAppointment(appointmentDTO);
        return ResponseEntity.ok("Appointment created successfully");
    }
    private final List<Appointment> appointments = new ArrayList<>();

    @PostMapping("/create")
    public void createAppointment(@RequestBody Appointment appointment) {
        appointments.add(appointment);
    }

    @GetMapping("/all")
    public List<Appointment> getAllAppointments() {
        return appointments;
    }


}
