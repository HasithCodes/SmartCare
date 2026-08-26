package com.example.smartcare.dto;

import lombok.Data;

@Data
public class DoctorDTO {
    private Long doctorId;
    private String doctorName;
    private String specialization;
    private String qualification;
    private String contactNumber;
    private Double consultationFee;
    private Long departmentId;
}
