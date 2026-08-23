package com.example.smartcare.service.impl;

import com.example.smartcare.entity.Appointment;
import com.example.smartcare.entity.Patient;
import com.example.smartcare.entity.Doctor;
import com.example.smartcare.dto.AppointmentDTO;
import com.example.smartcare.repository.AppointmentRepository;
import com.example.smartcare.repository.PatientRepository;
import com.example.smartcare.repository.DoctorRepository;
import com.example.smartcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    // ---------------- ENTITY METHODS ----------------

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment record not found with id: " + id));
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        Appointment existingAppointment = getAppointmentById(id);

        existingAppointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
        existingAppointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
        existingAppointment.setAppointmentStatus(updatedAppointment.getAppointmentStatus());
        existingAppointment.setConsultationRoom(updatedAppointment.getConsultationRoom());
        existingAppointment.setPatient(updatedAppointment.getPatient());
        existingAppointment.setDoctor(updatedAppointment.getDoctor());

        return appointmentRepository.save(existingAppointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        Appointment existingAppointment = getAppointmentById(id);
        appointmentRepository.delete(existingAppointment);
    }

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO dto) {
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + dto.getPatientId()));
        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + dto.getDoctorId()));

        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(java.time.LocalDate.parse(dto.getAppointmentDate()));
        appointment.setAppointmentTime(java.time.LocalTime.parse(dto.getAppointmentTime()));
        appointment.setAppointmentStatus(dto.getAppointmentStatus());
        appointment.setConsultationRoom(dto.getConsultationRoom());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        Appointment saved = appointmentRepository.save(appointment);
        return convertToDTO(saved);
    }

    @Override
    public List<AppointmentDTO> getAllAppointmentDTOs() {
        return appointmentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public AppointmentDTO getAppointmentDTOById(Long id) {
        Appointment appointment = getAppointmentById(id);
        return convertToDTO(appointment);
    }

    @Override
    public AppointmentDTO updateAppointment(Long id, AppointmentDTO dto) {
        Appointment existingAppointment = getAppointmentById(id);

        existingAppointment.setAppointmentDate(java.time.LocalDate.parse(dto.getAppointmentDate()));
        existingAppointment.setAppointmentTime(java.time.LocalTime.parse(dto.getAppointmentTime()));
        existingAppointment.setAppointmentStatus(dto.getAppointmentStatus());
        existingAppointment.setConsultationRoom(dto.getConsultationRoom());

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + dto.getPatientId()));
        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + dto.getDoctorId()));

        existingAppointment.setPatient(patient);
        existingAppointment.setDoctor(doctor);

        Appointment updated = appointmentRepository.save(existingAppointment);
        return convertToDTO(updated);
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setAppointmentId(appointment.getAppointmentId());
        dto.setAppointmentDate(appointment.getAppointmentDate().toString());
        dto.setAppointmentTime(appointment.getAppointmentTime().toString());
        dto.setAppointmentStatus(appointment.getAppointmentStatus());
        dto.setConsultationRoom(appointment.getConsultationRoom());
        dto.setPatientId(appointment.getPatient().getPatientId());
        dto.setDoctorId(appointment.getDoctor().getDoctorId());
        return dto;
    }
}
