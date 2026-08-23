package com.example.smartcare.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @Column(nullable = false)
    private String doctorName;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private String qualification;

    @Column(nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private Double consultationFee;

    @ManyToOne
    @JoinColumn(name = "department_id",  nullable = true)
    private Department department;
}