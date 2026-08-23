package com.example.smartcare.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bed")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bedId;

    @Column(nullable = false)
    private String bedNumber;

    @Column(nullable = false)
    private String bedStatus;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}