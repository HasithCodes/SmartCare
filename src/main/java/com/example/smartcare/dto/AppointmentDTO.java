package com.example.smartcare.dto;

import lombok.Data;

@Data
public class AppointmentDTO {
    private Long appointmentId;
    private String appointmentDate;
    private String appointmentTime;
    private String appointmentStatus;
    private String consultationRoom;
    private Long patientId;
    private Long doctorId;
}
