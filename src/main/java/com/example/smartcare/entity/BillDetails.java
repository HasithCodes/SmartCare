package com.example.smartcare.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bill_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billDetailId;

    @Column(nullable = false)
    private String chargeType;

    @Column(nullable = false)
    private BigDecimal chargeAmount;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;
}