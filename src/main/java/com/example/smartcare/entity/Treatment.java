package com.example.smartcare.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "treatment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long treatmentId;

    @Column(nullable = false)
    private String diagnosis;

    @Column(nullable = false)
    private String prescriptionDetails;

    @Column(nullable = false)
    private String treatmentNotes;

    @Column(nullable = false)
    private LocalDate treatmentDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}