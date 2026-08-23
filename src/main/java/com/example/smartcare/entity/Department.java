package com.example.smartcare.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(nullable = false)
    private String departmentName;

    @Column(nullable = false)
    private String location;

    @OneToOne
    @JoinColumn(name = "head_doctor_id",  nullable = true)
    @JsonIgnore
    private Doctor headDoctor;

    public Long getHeadDoctorId() {
        return headDoctor != null ? headDoctor.getDoctorId() : null;
    }
}
