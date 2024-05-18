package com.example.Apointify_App.Controller;

import com.example.Apointify_App.Dto.CalendarAvocatDTO;
import com.example.Apointify_App.Service.CalendarAvocatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/calendar-avocats")
public class CalendarAvocatController {
    private final CalendarAvocatService calendarAvocatService;

    @Autowired
    public CalendarAvocatController(CalendarAvocatService calendarAvocatService) {
        this.calendarAvocatService = calendarAvocatService;
    }

    @GetMapping
    public List<CalendarAvocatDTO> getAllCalendarAvocats() {
        return calendarAvocatService.getAllCalendarAvocat();
    }

    @GetMapping("/{id}")
    public CalendarAvocatDTO getCalendarAvocatById(@PathVariable Integer id) {
        return calendarAvocatService.getCalendarAvocatById(id);
    }

    @PostMapping
    public CalendarAvocatDTO createCalendarAvocat(@RequestBody CalendarAvocatDTO calendarAvocatDTO) {
        return calendarAvocatService.createCalendar(calendarAvocatDTO);
    }
}
