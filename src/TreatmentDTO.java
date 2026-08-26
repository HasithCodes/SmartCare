package com.example.smartcare.dto;

import lombok.Data;

@Data
public class TreatmentDTO {
    private Long treatmentId;
    private String diagnosis;
    private String prescriptionDetails;
    private String treatmentNotes;
    private String treatmentDate;   // String for JSON simplicity
    private Long patientId;
    private Long doctorId;
}
