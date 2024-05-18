package com.example.Apointify_App.Service;

import com.example.Apointify_App.Dto.CalendarAvocatDTO;
import com.example.Apointify_App.Entity.CalendarAvocat;
import com.example.Apointify_App.Repo.CalendarAvocatRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalendarAvocatService {
    private final CalendarAvocatRepository calendarAvocatRepository;

    @Autowired
    public CalendarAvocatService(CalendarAvocatRepository calendarAvocatRepository) {
        this.calendarAvocatRepository = calendarAvocatRepository;
    }

    public List<CalendarAvocatDTO> getAllCalendarAvocat() {
        return calendarAvocatRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CalendarAvocatDTO getCalendarAvocatById(Integer id) {
        CalendarAvocat calendarAvocat = calendarAvocatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Calendar Event Id:" + id));
        return convertToDTO(calendarAvocat);
    }

    public CalendarAvocatDTO createCalendar(CalendarAvocatDTO calendarAvocatDTO) {
        CalendarAvocat calendarAvocat = convertToEntity(calendarAvocatDTO);
        CalendarAvocat savedCalendarAvocat = calendarAvocatRepository.save(calendarAvocat);
        return convertToDTO(savedCalendarAvocat);
    }

    private CalendarAvocatDTO convertToDTO(CalendarAvocat calendarEvent) {
        CalendarAvocatDTO calendarAvocatDTO = new CalendarAvocatDTO();
        BeanUtils.copyProperties(calendarAvocatDTO, calendarAvocatDTO);
        return calendarAvocatDTO;
    }

    private CalendarAvocat convertToEntity(CalendarAvocatDTO calendarAvocatDTO) {
        CalendarAvocat calendarAvocat = new CalendarAvocat();
        BeanUtils.copyProperties(calendarAvocatDTO, calendarAvocat);
        return calendarAvocat;
    }
}
