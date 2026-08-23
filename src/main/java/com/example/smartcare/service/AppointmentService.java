package com.example.smartcare.service;

import com.example.smartcare.entity.Appointment;
import com.example.smartcare.dto.AppointmentDTO;
import java.util.List;

public interface AppointmentService {

    Appointment createAppointment(Appointment appointment);

    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);

    List<Appointment> getAllAppointments();

    List<AppointmentDTO> getAllAppointmentDTOs();

    Appointment getAppointmentById(Long id);

    AppointmentDTO getAppointmentDTOById(Long id);

    Appointment updateAppointment(Long id, Appointment appointment);

    AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO);

    void deleteAppointment(Long id);
}
