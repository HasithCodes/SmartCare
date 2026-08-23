package com.example.smartcare.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}