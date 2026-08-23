package com.example.smartcare.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "room")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(nullable = false)
    private String roomCategory;

    @Column(nullable = false)
    private String availabilityStatus;
}