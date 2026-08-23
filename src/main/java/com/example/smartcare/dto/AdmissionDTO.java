package com.example.smartcare.dto;

import lombok.Data;

@Data
public class AdmissionDTO {
    private Long admissionId;
    private String admissionDate;
    private String dischargeDate;
    private String admissionStatus;
    private Long patientId;
    private Long bedId;
}
