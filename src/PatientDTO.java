package com.example.smartcare.dto;

import lombok.Data;

@Data
public class PatientDTO {
    private Long patientId;
    private String fullName;
    private String dob;
    private String gender;
    private String address;
    private String contactDetails;
    private String bloodGroup;
    private String emergencyContact;
}
