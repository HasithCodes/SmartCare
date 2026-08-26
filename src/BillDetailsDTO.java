package com.example.smartcare.dto;

import lombok.Data;

@Data
public class BillDetailsDTO {
    private Long billDetailId;
    private String chargeType;
    private Double chargeAmount;
    private Long billId;
}
