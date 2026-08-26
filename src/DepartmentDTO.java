package com.example.smartcare.dto;

import lombok.Data;

@Data
public class DepartmentDTO {
    private Long departmentId;
    private String departmentName;
    private String location;
    private Long headDoctorId;   // flatten relationship
}
