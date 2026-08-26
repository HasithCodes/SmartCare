package com.example.smartcare.dto;

import lombok.Data;

@Data
public class LaboratoryTestDTO {
    private Long labTestId;
    private String testName;
    private String testDate;       // String for JSON simplicity
    private String testResult;
    private String technicianName;
    private String testStatus;
    private Long patientId;
    private Long doctorId;
}
