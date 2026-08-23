package com.example.smartcare.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "admission")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admissionId;

    @Column(nullable = false)
    private LocalDateTime admissionDate;

    @Column(nullable = false)
    private LocalDateTime dischargeDate;

    @Column(nullable = false)
    private String admissionStatus;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "bed_id")
    private Bed bed;
}