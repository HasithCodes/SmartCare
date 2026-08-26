package com.example.smartcare.dto;

import lombok.Data;

@Data
public class BillDTO {
    private Long billId;
    private String billDate;
    private Double totalAmount;
    private String paymentStatus;
    private String paymentMethod;
    private Long patientId;
    private Long appointmentId;
    private Long admissionId;
}
