package com.example.smartcare.controller;

import com.example.smartcare.dto.AppointmentDTO;
import com.example.smartcare.entity.Appointment;
import com.example.smartcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // CREATE using DTO
    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentService.createAppointment(appointmentDTO));
    }

    // READ ALL as DTOs
    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointmentDTOs());
    }

    // READ BY ID as DTO
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentDTOById(id));
    }

    // UPDATE using DTO
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable Long id,
                                                            @RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentService.updateAppointment(id, appointmentDTO));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok("Appointment record deleted successfully.");
    }

    @PostMapping("/entity")
    public ResponseEntity<Appointment> createAppointmentEntity(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.createAppointment(appointment));
    }

    @GetMapping("/entity")
    public ResponseEntity<List<Appointment>> getAllAppointmentsEntity() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/entity/{id}")
    public ResponseEntity<Appointment> getAppointmentEntityById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @PutMapping("/entity/{id}")
    public ResponseEntity<Appointment> updateAppointmentEntity(@PathVariable Long id,
                                                               @RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.updateAppointment(id, appointment));
    }
}
