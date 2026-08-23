package com.example.smartcare.repository;

import com.example.smartcare.entity.BillDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailsRepository extends JpaRepository<BillDetails, Long> {}