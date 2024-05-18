package com.example.Apointify_App.Controller;

import com.example.Apointify_App.Dto.AppointmentDto;
import com.example.Apointify_App.Entity.Appointment;
import com.example.Apointify_App.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CalendarController {

    private final AppointmentService appointmentService;

    public CalendarController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/calendar")
    public String calendar(Model model) {
        List<AppointmentDto> appointments = appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointments);
        return "calendar";
    }


    @PostMapping("/addEvent")
    public String addEvent(@RequestParam("date") String date,
                           @RequestParam("title") String title,
                           @RequestParam("description") String description,
                           Model model) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setDate(LocalDate.parse(date));
        appointmentDto.setTitle(title);
        appointmentDto.setDescription(description);
        appointmentService.addAppointment(appointmentDto);

        List<AppointmentDto> appointments = appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointments);
        return "fragments :: calendar";
    }


    @PostMapping("/deleteEvent")
    public String deleteEvent(@RequestParam("eventId") Long eventId) {
        appointmentService.deleteAppointmentById(eventId);
        return "redirect:/calendar";
    }
}