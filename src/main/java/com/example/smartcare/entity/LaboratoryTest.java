package com.example.smartcare.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "laboratory_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaboratoryTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labTestId;

    @Column(nullable = false)
    private String testName;

    @Column(nullable = false)
    private LocalDate testDate;

    @Column(nullable = false)
    private String testResult;

    @Column(nullable = false)
    private String technicianName;

    @Column(nullable = false)
    private String testStatus;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}