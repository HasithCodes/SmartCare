package com.example.smartcare.repository;

import com.example.smartcare.entity.LaboratoryTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryTestRepository extends JpaRepository<LaboratoryTest, Long> {}