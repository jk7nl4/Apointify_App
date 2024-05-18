package com.example.Apointify_App.Service;

import com.example.Apointify_App.Dto.AppointmentDto;
import com.example.Apointify_App.Entity.Appointment;
import com.example.Apointify_App.Entity.user.Avocat;
import com.example.Apointify_App.Repo.AppointmentRepository;
import com.example.Apointify_App.Repo.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final ClientRepository clientRepository;
    @Autowired
    private AppointmentRepository AppointmentRepository;


    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, ClientRepository clientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.clientRepository = clientRepository;
    }

    public List<AppointmentDto> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AppointmentDto getAppointmentById(Integer id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Appointment Id:" + id));
        return convertToDTO(appointment);
    }

    public Appointment createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setName(appointmentDto.getName());
        appointment.setEmail(appointmentDto.getEmail());
        appointment.setPhone(appointmentDto.getPhone());
        appointment.setDate(appointmentDto.getDate());
        appointment.setTime(appointmentDto.getTime());
        appointment.setId(appointmentDto.getLawyerId());
        appointmentRepository.save(appointment);
        return appointment;
    }

    private AppointmentDto convertToDTO(Appointment appointment) {
        AppointmentDto appointmentDTO = new AppointmentDto();
        BeanUtils.copyProperties(appointment, appointmentDTO);
        return appointmentDTO;
    }

    private Appointment convertToEntity(AppointmentDto appointmentDTO) {
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(appointmentDTO, appointment);
        return appointment;
    }

    public List<AppointmentDto> getAllAcceptedAppointmentsForAvocat(Avocat avocat) {
        List<Appointment> appointments = appointmentRepository.findByAvocatAndStatus(avocat, "Accepted");
        return appointments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public void saveAppointment(Appointment appointment) {
    }

    public Appointment saveAppointment(AppointmentDto appointmentDto) {
        return new Appointment();
    }

    public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
        return appointmentDto;
    }

    public void deleteAppointmentById(Long eventId) {
    }
}
