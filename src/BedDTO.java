package com.example.smartcare.dto;

import lombok.Data;

@Data
public class BedDTO {
    private Long bedId;
    private String bedNumber;
    private String bedStatus;
    private Long roomId;   // flatten relationship
}
